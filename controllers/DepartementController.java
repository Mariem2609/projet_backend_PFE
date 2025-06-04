package controllers;

import entities.Departement;
import services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departements")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping
    public ResponseEntity<List<Departement>> getAllDepartements() {
        try {
            List<Departement> departements = departementService.findAll();
            return new ResponseEntity<>(departements, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable Long id) {
        Optional<Departement> departement = departementService.findById(id);
        if (departement.isPresent()) {
            return new ResponseEntity<>(departement.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Departement> createDepartement(@Valid @RequestBody Departement departement) {
        try {
            Departement nouveauDepartement = departementService.save(departement);
            return new ResponseEntity<>(nouveauDepartement, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable Long id, @Valid @RequestBody Departement departement) {
        Optional<Departement> departementExistant = departementService.findById(id);
        if (departementExistant.isPresent()) {
            departement.setIdDepartement(id);
            Departement departementMisAJour = departementService.save(departement);
            return new ResponseEntity<>(departementMisAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDepartement(@PathVariable Long id) {
        try {
            departementService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Récupérer les équipements d'un département
    @GetMapping("/{id}/equipements")
    public ResponseEntity<List<entities.Equipement>> getEquipementsByDepartement(@PathVariable Long id) {
        try {
            List<entities.Equipement> equipements = departementService.getEquipementsByDepartement(id);
            return new ResponseEntity<>(equipements, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}