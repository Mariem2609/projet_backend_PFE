package controllers;

import entities.TypeIntervention;
import services.TypeInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/types-intervention")
@CrossOrigin(origins = "http://localhost:3000")
public class TypeInterventionController {

    @Autowired
    private TypeInterventionService typeInterventionService;

    @GetMapping
    public ResponseEntity<List<TypeIntervention>> getAllTypesIntervention() {
        try {
            List<TypeIntervention> types = typeInterventionService.findAll();
            return new ResponseEntity<>(types, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeIntervention> getTypeInterventionById(@PathVariable Long id) {
        Optional<TypeIntervention> type = typeInterventionService.findById(id);
        if (type.isPresent()) {
            return new ResponseEntity<>(type.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TypeIntervention> createTypeIntervention(@Valid @RequestBody TypeIntervention type) {
        try {
            TypeIntervention nouveauType = typeInterventionService.save(type);
            return new ResponseEntity<>(nouveauType, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeIntervention> updateTypeIntervention(@PathVariable Long id, @Valid @RequestBody TypeIntervention type) {
        Optional<TypeIntervention> typeExistant = typeInterventionService.findById(id);
        if (typeExistant.isPresent()) {
            type.setIdType(id);
            TypeIntervention typeMisAJour = typeInterventionService.save(type);
            return new ResponseEntity<>(typeMisAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTypeIntervention(@PathVariable Long id) {
        try {
            typeInterventionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
