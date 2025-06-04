package repositories;

import entities.Intervention;
import enums.InterventionStatus;
import enums.InterventionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long> {

    List<Intervention> findByEquipmentId(Long equipmentId);
    List<Intervention> findByStatut(InterventionStatus statut);
    List<Intervention> findByTypeIntervention(InterventionType typeIntervention);
    List<Intervention> findByTechnicien(String technicien);

    @Query("SELECT i FROM Intervention i WHERE i.dateIntervention BETWEEN :startDate AND :endDate")
    List<Intervention> findByDateInterventionBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT COUNT(i) FROM Intervention i WHERE i.statut = :statut")
    Long countByStatut(InterventionStatus statut);

    @Query("SELECT i.typeIntervention, COUNT(i) FROM Intervention i GROUP BY i.typeIntervention")
    List<Object[]> countInterventionsByType();

    @Query("SELECT i FROM Intervention i WHERE i.technicien = :technicien AND i.statut = :statut")
    List<Intervention> findByTechnicienAndStatut(String technicien, InterventionStatus statut);
}