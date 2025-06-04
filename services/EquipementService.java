package services;

import entities.Equipement;
import enums.EquipementStatus;
import enums.EquipementType;
import jakarta.validation.Valid;
import repositories.EquipementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EquipementService {

    private final EquipementRepository equipmentRepository;
    private Equipement Equipement;

    public List<Equipement> getAllEquipments() {
        return equipmentRepository.findAll();
    }

    public Optional<Equipement> getEquipmentById(Long id) {
        return equipmentRepository.findById(id);
    }

    public Equipement saveEquipment(Equipement equipment) {
        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }

    public Optional<Equipement> findByCodeInventaire(String codeInventaire) {
        return equipmentRepository.findByCodeInventaire(codeInventaire);
    }

    public List<Equipement> getEquipmentsByStatus(EquipementStatus status) {
        return equipmentRepository.findByStatut(status);
    }

    public List<Equipement> getEquipmentsByType(EquipementType type) {
        return equipmentRepository.findByTypeEquipement(type);
    }

    public List<Equipement> searchEquipments(String keyword) {
        return equipmentRepository.searchByKeyword(keyword);
    }

    public List<Equipement> getEquipmentsWithExpiringWarranty(int daysAhead) {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(daysAhead);
        return equipmentRepository.findByGarantieExpiringBetween(today, futureDate);
    }

    public Long getEquipmentCountByStatus(EquipementStatus status) {
        return equipmentRepository.countByStatut(status);
    }

    public List<Equipement> findAll() {
        return equipmentRepository.findAll();
    }

    public Optional<Equipement> findById(Long id) {
        return equipmentRepository.findById(id);
    }

    public Equipement save(@Valid Equipement equipement) {
        return equipmentRepository.save(Equipement);
    }

    public void deleteById(Long id) {
    }

    public List<Equipement> findByEtat(Equipement.EtatEquipement etat) {
        return equipmentRepository.findAll();
    }

    public List<Equipement> findByDepartement(Long departementId) {
        return equipmentRepository.findAll();
    }

    public List<Equipement> findByCategorie(Long categorieId) {
        return equipmentRepository.findAll();
    }

    public List<Equipement> findByNumeroSerie(String numeroSerie) {
        return equipmentRepository.findAll();
    }
}