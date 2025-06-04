package controllers;

import entities.Alerte;
import services.AlerteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alertes")
@CrossOrigin(origins = "http://localhost:3000")
public class AlerteController {

    @Autowired
    private AlerteService alerteService;

    @GetMapping
    public ResponseEntity<List<Alerte>> getAllAlertes() {
        try {
            List<Alerte> alertes = alerteService.findAll();
            return new ResponseEntity<>(alertes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerte> getAlerteById(@PathVariable Long id) {
        Optional<Alerte> alerte = alerteService.findById(id);
        if (alerte.isPresent()) {
            return new ResponseEntity<>(alerte.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Alerte> createAlerte(@Valid @RequestBody Alerte alerte) {
        try {
            Alerte nouvelleAlerte = alerteService.save(alerte);
            return new ResponseEntity<>(nouvelleAlerte, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT - Marquer une alerte comme lue
    @PutMapping("/{id}/lue")
    public ResponseEntity<Alerte> marquerCommeLue(@PathVariable Long id) {
        try {
            Alerte alerte = alerteService.marquerCommeLue(id);
            return new ResponseEntity<>(alerte, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // GET - Alertes non lues
    @GetMapping("/non-lues")
    public ResponseEntity<List<Alerte>> getAlertesNonLues() {
        try {
            List<Alerte> alertes = alerteService.findAlertesNonLues();
            return new ResponseEntity<>(alertes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAlerte(@PathVariable Long id) {
        try {
            alerteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
