package services;

import entities.Alerte;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface AlerteService {
    List<Alerte> findAll();

    Optional<Alerte> findById(Long id);

    Alerte save(@Valid Alerte alerte);

    Alerte marquerCommeLue(Long id);

    List<Alerte> findAlertesNonLues();

    void deleteById(Long id);
}
