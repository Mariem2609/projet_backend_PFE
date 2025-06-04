package services;

import entities.HistoriqueModification;

import java.util.List;
import java.util.Optional;

public interface HistoriqueService {
    List<HistoriqueModification> findAll();

    Optional<HistoriqueModification> findById(Long id);

    List<HistoriqueModification> findByEquipement(Long equipementId);

    List<HistoriqueModification> findByUtilisateur(Long utilisateurId);
}
