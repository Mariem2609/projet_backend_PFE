package controllers;

import entities.CategorieEquipement;
import services.CategorieEquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategorieEquipementController {

    @Autowired
    private CategorieEquipementService categorieService;

    @GetMapping
    public ResponseEntity<List<CategorieEquipement>> getAllCategories() {
        try {
            List<CategorieEquipement> categories = categorieService.findAll();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorieEquipement> getCategorieById(@PathVariable Long id) {
        Optional<CategorieEquipement> categorie = categorieService.findById(id);
        if (categorie.isPresent()) {
            return new ResponseEntity<>(categorie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CategorieEquipement> createCategorie(@Valid @RequestBody CategorieEquipement categorie) {
        try {
            CategorieEquipement nouvelleCategorie = categorieService.save(categorie);
            return new ResponseEntity<>(nouvelleCategorie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategorieEquipement> updateCategorie(@PathVariable Long id, @Valid @RequestBody CategorieEquipement categorie) {
        Optional<CategorieEquipement> categorieExistante = categorieService.findById(id);
        if (categorieExistante.isPresent()) {
            categorie.setIdCategorie(id);
            CategorieEquipement categorieMiseAJour = categorieService.save(categorie);
            return new ResponseEntity<>(categorieMiseAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategorie(@PathVariable Long id) {
        try {
            categorieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}