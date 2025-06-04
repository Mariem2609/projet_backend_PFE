package services;

import entities.Intervention;
import enums.InterventionStatus;
import enums.InterventionType;
import repositories.InterventionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class InterventionService {

    private final InterventionRepository interventionRepository;

    public List<Intervention> getAllInterventions() {
        return interventionRepository.findAll();
    }

    public Optional<Intervention> getInterventionById(Long id) {
        return interventionRepository.findById(id);
    }

    public Intervention saveIntervention(Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    public void deleteIntervention(Long id) {
        interventionRepository.deleteById(id);
    }

    public List<Intervention> getInterventionsByEquipment(Long equipmentId) {
        return interventionRepository.findByEquipmentId(equipmentId);
    }

    public List<Intervention> getInterventionsByTechnician(String technicien) {
        return interventionRepository.findByTechnicien(technicien);
    }

    public List<Intervention> getInterventionsByStatus(InterventionStatus status) {
        return interventionRepository.findByStatut(status);
    }

    public List<Intervention> getInterventionsByDateRange(LocalDate startDate, LocalDate endDate) {
        return interventionRepository.findByDateInterventionBetween(startDate, endDate);
    }

    public Long getInterventionCountByStatus(InterventionStatus status) {
        return interventionRepository.countByStatut(status);
    }
}