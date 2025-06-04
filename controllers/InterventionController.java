package controllers;

import entities.Intervention;
import services.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interventions")
@CrossOrigin(origins = "http://localhost:3000")
public class InterventionController {

    @Autowired
    private InterventionService interventionService;

    @GetMapping
    public ResponseEntity<List<Intervention>> getAllInterventions() {
        try {
            List<Intervention> interventions = interventionService.findAll();
            return new ResponseEntity<>(interventions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Intervention> getInterventionById(@PathVariable Long id) {
        Optional<Intervention> intervention = interventionService.findById(id);
        if (intervention.isPresent()) {
            return new ResponseEntity<>(intervention.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Intervention> createIntervention(@Valid @RequestBody Intervention intervention) {
        try {
            Intervention nouvelleIntervention = interventionService.save(intervention);
            return new ResponseEntity<>(nouvelleIntervention, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Intervention> updateIntervention(@PathVariable Long id, @Valid @RequestBody Intervention intervention) {
        Optional<Intervention> interventionExistante = interventionService.findById(id);
        if (interventionExistante.isPresent()) {
            intervention.setIdIntervention(id);
            Intervention interventionMiseAJour = interventionService.save(intervention);
            return new ResponseEntity<>(interventionMiseAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteIntervention(@PathVariable Long id) {
        try {
            interventionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // POST - Assigner un technicien à une intervention
    @PostMapping("/{id}/assigner/{technicienId}")
    public ResponseEntity<Intervention> assignerTechnicien(@PathVariable Long id, @PathVariable Long technicienId) {
        try {
            Intervention intervention = interventionService.assignerTechnicien(id, technicienId);
            return new ResponseEntity<>(intervention, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT - Mettre à jour le statut d'une intervention
    @PutMapping("/{id}/statut")
    public ResponseEntity<Intervention> updateStatut(@PathVariable Long id, @RequestBody StatutRequest statutRequest) {
        try {
            Intervention intervention = interventionService.updateStatut(id, statutRequest.getStatut());
            return new ResponseEntity<>(intervention, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT - Ajouter une solution à une intervention
    @PutMapping("/{id}/solution")
    public ResponseEntity<Intervention> addSolution(@PathVariable Long id, @RequestBody SolutionRequest solutionRequest) {
        try {
            Intervention intervention = interventionService.addSolution(id, solutionRequest.getSolution());
            return new ResponseEntity<>(intervention, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // GET - Filtrer par statut
    @GetMapping("/statut/{statut}")
    public ResponseEntity<List<Intervention>> getInterventionsByStatut(@PathVariable Intervention.EtatIntervention statut) {
        try {
            List<Intervention> interventions = interventionService.findByStatut(statut);
            return new ResponseEntity<>(interventions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Filtrer par équipement
    @GetMapping("/equipement/{equipementId}")
    public ResponseEntity<List<Intervention>> getInterventionsByEquipement(@PathVariable Long equipementId) {
        try {
            List<Intervention> interventions = interventionService.findByEquipement(equipementId);
            return new ResponseEntity<>(interventions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Classes internes pour les requêtes
    public static class StatutRequest {
        private Intervention.EtatIntervention statut;

        public Intervention.EtatIntervention getStatut() { return statut; }
        public void setStatut(Intervention.EtatIntervention statut) { this.statut = statut; }
    }

    public static class SolutionRequest {
        private String solution;

        public String getSolution() { return solution; }
        public void setSolution(String solution) { this.solution = solution; }
    }
}