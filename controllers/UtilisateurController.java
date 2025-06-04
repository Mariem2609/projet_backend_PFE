package controllers;

import entities.Utilisateur;
import services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "http://localhost:3000")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // GET - Récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        try {
            List<Utilisateur> utilisateurs = utilisateurService.findAll();
            return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurService.findById(id);
        if (utilisateur.isPresent()) {
            return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST - Créer un nouvel utilisateur
    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        try {
            Utilisateur nouvelUtilisateur = utilisateurService.save(utilisateur);
            return new ResponseEntity<>(nouvelUtilisateur, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT - Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @Valid @RequestBody Utilisateur utilisateur) {
        Optional<Utilisateur> utilisateurExistant = utilisateurService.findById(id);
        if (utilisateurExistant.isPresent()) {
            utilisateur.setIdUtilisateur(id);
            Utilisateur utilisateurMisAJour = utilisateurService.save(utilisateur);
            return new ResponseEntity<>(utilisateurMisAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE - Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUtilisateur(@PathVariable Long id) {
        try {
            utilisateurService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // POST - Authentification
    @PostMapping("/login")
    public ResponseEntity<Utilisateur> login(@RequestBody LoginRequest loginRequest) {
        try {
            Optional<Utilisateur> utilisateur = utilisateurService.authenticate(loginRequest.getEmail(), loginRequest.getMotDePasse());
            if (utilisateur.isPresent()) {
                return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Classe interne pour la requête de login
    public static class LoginRequest {
        private String email;
        private String motDePasse;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getMotDePasse() { return motDePasse; }
        public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    }
}