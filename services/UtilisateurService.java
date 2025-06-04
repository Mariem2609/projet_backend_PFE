package services;

import entities.Utilisateur;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    List<Utilisateur> findAll();

    Optional<Utilisateur> findById(Long id);

    Utilisateur save(@Valid Utilisateur utilisateur);

    void deleteById(Long id);

    Optional<Utilisateur> authenticate(String email, String motDePasse);
}
