package repositories;
import entities.Assignment;
import enums.AssignmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByEmployeeId(Long employeeId);
    List<Assignment> findByEquipmentId(Long equipmentId);
    List<Assignment> findByStatut(AssignmentStatus statut);

    @Query("SELECT a FROM Assignment a WHERE a.employee.id = :employeeId AND a.statut = :statut")
    List<Assignment> findByEmployeeAndStatut(Long employeeId, AssignmentStatus statut);

    @Query("SELECT a FROM Assignment a WHERE a.equipment.id = :equipmentId AND a.statut = 'ACTIVE'")
    List<Assignment> findActiveAssignmentsByEquipment(Long equipmentId);

    @Query("SELECT a FROM Assignment a WHERE a.dateDebut BETWEEN :startDate AND :endDate")
    List<Assignment> findByDateDebutBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT COUNT(a) FROM Assignment a WHERE a.statut = 'ACTIVE'")
    Long countActiveAssignments();
}