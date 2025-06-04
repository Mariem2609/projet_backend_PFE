package services;

import entities.TypeIntervention;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface TypeInterventionService {
    List<TypeIntervention> findAll();

    Optional<TypeIntervention> findById(Long id);

    TypeIntervention save(@Valid TypeIntervention type);

    void deleteById(Long id);
}
