package controllers; // Changé de "controller" à "controllers"

import entities.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import services.AssignmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "http://localhost:3000") // Ajout de CORS pour cohérence
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService; // Utilisation du service au lieu du repository direct

    @GetMapping
    public ResponseEntity<List<Assignment>> getAll() {
        try {
            List<Assignment> assignments = assignmentService.findAll();
            return new ResponseEntity<>(assignments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getById(@PathVariable Long id) {
        Optional<Assignment> assignment = assignmentService.findById(id);
        if (assignment.isPresent()) {
            return new ResponseEntity<>(assignment.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Assignment> create(@Valid @RequestBody Assignment assignment) {
        try {
            Assignment newAssignment = assignmentService.save(assignment);
            return new ResponseEntity<>(newAssignment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> update(@PathVariable Long id, @Valid @RequestBody Assignment assignment) {
        Optional<Assignment> assignmentExistant = assignmentService.findById(id);
        if (assignmentExistant.isPresent()) {
            assignment.setId(id); // Supposant que la méthode s'appelle setId
            Assignment assignmentMisAJour = assignmentService.save(assignment);
            return new ResponseEntity<>(assignmentMisAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        try {
            assignmentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}