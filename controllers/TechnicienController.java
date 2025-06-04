package controllers;

import entities.Technicien;
import services.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/techniciens")
@CrossOrigin(origins = "http://localhost:3000")
public class TechnicienController {

    @Autowired
    private TechnicienService technicienService;

    @GetMapping
    public ResponseEntity<List<Technicien>> getAllTechniciens() {
        try {
            List<Technicien> techniciens = technicienService.findAll();
            return new ResponseEntity<>(techniciens, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technicien> getTechnicienById(@PathVariable Long id) {
        Optional<Technicien> technicien = technicienService.findById(id);
        if (technicien.isPresent()) {
            return new ResponseEntity<>(technicien.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Technicien> createTechnicien(@Valid @RequestBody Technicien technicien) {
        try {
            Technicien nouveauTechnicien = technicienService.save(technicien);
            return new ResponseEntity<>(nouveauTechnicien, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technicien> updateTechnicien(@PathVariable Long id, @Valid @RequestBody Technicien technicien) {
        Optional<Technicien> technicienExistant = technicienService.findById(id);
        if (technicienExistant.isPresent()) {
            technicien.setIdTechnicien(id);
            Technicien technicienMisAJour = technicienService.save(technicien);
            return new ResponseEntity<>(technicienMisAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTechnicien(@PathVariable Long id) {
        try {
            technicienService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Récupérer les interventions d'un technicien
    @GetMapping("/{id}/interventions")
    public ResponseEntity<List<entities.Intervention>> getInterventionsByTechnicien(@PathVariable Long id) {
        try {
            List<entities.Intervention> interventions = technicienService.getInterventionsByTechnicien(id);
            return new ResponseEntity<>(interventions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Récupérer les interventions actives d'un technicien
    @GetMapping("/{id}/interventions/actives")
    public ResponseEntity<List<entities.Intervention>> getInterventionsActivesByTechnicien(@PathVariable Long id) {
        try {
            List<entities.Intervention> interventions = technicienService.getInterventionsActivesByTechnicien(id);
            return new ResponseEntity<>(interventions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}