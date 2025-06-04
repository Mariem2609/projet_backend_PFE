package services;

import entities.Intervention;
import entities.Technicien;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface TechnicienService {
    List<Technicien> findAll();

    Optional<Technicien> findById(Long id);

    Technicien save(@Valid Technicien technicien);

    void deleteById(Long id);

    List<Intervention> getInterventionsByTechnicien(Long id);

    List<Intervention> getInterventionsActivesByTechnicien(Long id);
}
