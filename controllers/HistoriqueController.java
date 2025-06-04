package controllers;

import entities.HistoriqueModification;
import services.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historiques")
@CrossOrigin(origins = "http://localhost:3000")
public class HistoriqueController {

    @Autowired
    private HistoriqueService historiqueService;

    @GetMapping
    public ResponseEntity<List<HistoriqueModification>> getAllHistoriques() {
        try {
            List<HistoriqueModification> historiques = historiqueService.findAll();
            return new ResponseEntity<>(historiques, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriqueModification> getHistoriqueById(@PathVariable Long id) {
        Optional<HistoriqueModification> historique = historiqueService.findById(id);
        if (historique.isPresent()) {
            return new ResponseEntity<>(historique.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // GET - Historique par équipement
    @GetMapping("/equipement/{equipementId}")
    public ResponseEntity<List<HistoriqueModification>> getHistoriqueByEquipement(@PathVariable Long equipementId) {
        try {
            List<HistoriqueModification> historiques = historiqueService.findByEquipement(equipementId);
            return new ResponseEntity<>(historiques, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Historique par utilisateur
    @GetMapping("/utilisateur/{utilisateurId}")
    public ResponseEntity<List<HistoriqueModification>> getHistoriqueByUtilisateur(@PathVariable Long utilisateurId) {
        try {
            List<HistoriqueModification> historiques = historiqueService.findByUtilisateur(utilisateurId);
            return new ResponseEntity<>(historiques, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

