package services;

import entities.CategorieEquipement;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface CategorieEquipementService {
    List<CategorieEquipement> findAll();

    Optional<CategorieEquipement> findById(Long id);

    CategorieEquipement save(@Valid CategorieEquipement categorie);

    void deleteById(Long id);
}
