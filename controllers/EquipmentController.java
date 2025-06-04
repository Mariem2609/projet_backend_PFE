package controllers;

import entities.Equipement;
import services.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipements")
@CrossOrigin(origins = "http://localhost:3000")
public class EquipmentController {

    @Autowired
    private EquipementService equipementService;

    @GetMapping
    public ResponseEntity<List<Equipement>> getAllEquipements() {
        try {
            List<Equipement> equipements = equipementService.findAll();
            return new ResponseEntity<>(equipements, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        Optional<Equipement> equipement = equipementService.findById(id);
        if (equipement.isPresent()) {
            return new ResponseEntity<>(equipement.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Equipement> createEquipement(@Valid @RequestBody Equipement equipement) {
        try {
            Equipement nouvelEquipement = equipementService.save(equipement);
            return new ResponseEntity<>(nouvelEquipement, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> updateEquipement(@PathVariable Long id, @Valid @RequestBody Equipement equipement) {
        Optional<Equipement> equipementExistant = equipementService.findById(id);
        if (equipementExistant.isPresent()) {
            equipement.setIdEquipement(id);
            Equipement equipementMisAJour = equipementService.save(equipement);
            return new ResponseEntity<>(equipementMisAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEquipement(@PathVariable Long id) {
        try {
            equipementService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Filtrer par état
    @GetMapping("/etat/{etat}")
    public ResponseEntity<List<Equipement>> getEquipementsByEtat(@PathVariable Equipement.EtatEquipement etat) {
        try {
            List<Equipement> equipements = equipementService.findByEtat(etat);
            return new ResponseEntity<>(equipements, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Filtrer par département
    @GetMapping("/departement/{departementId}")
    public ResponseEntity<List<Equipement>> getEquipementsByDepartement(@PathVariable Long departementId) {
        try {
            List<Equipement> equipements = equipementService.findByDepartement(departementId);
            return new ResponseEntity<>(equipements, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Filtrer par catégorie
    @GetMapping("/categorie/{categorieId}")
    public ResponseEntity<List<Equipement>> getEquipementsByCategorie(@PathVariable Long categorieId) {
        try {
            List<Equipement> equipements = equipementService.findByCategorie(categorieId);
            return new ResponseEntity<>(equipements, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Recherche par numéro de série
    @GetMapping("/numero-serie/{numeroSerie}")
    public ResponseEntity<Equipement> getEquipementByNumeroSerie(@PathVariable String numeroSerie) {
        Optional<Equipement> equipement = equipementService.findByNumeroSerie(numeroSerie);
        if (equipement.isPresent()) {
            return new ResponseEntity<>(equipement.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
