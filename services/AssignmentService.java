package services;

import entities.Assignment;
import enums.AssignmentStatus;
import repositories.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }

    public List<Assignment> getAssignmentsByEmployee(Long employeeId) {
        return assignmentRepository.findByEmployeeId(employeeId);
    }

    public List<Assignment> getAssignmentsByEquipment(Long equipmentId) {
        return assignmentRepository.findByEquipmentId(equipmentId);
    }

    public List<Assignment> getActiveAssignments() {
        return assignmentRepository.findByStatut(AssignmentStatus.ACTIVE);
    }

    public Assignment terminateAssignment(Long assignmentId, LocalDate dateFin) {
        Optional<Assignment> assignmentOpt = assignmentRepository.findById(assignmentId);
        if (assignmentOpt.isPresent()) {
            Assignment assignment = assignmentOpt.get();
            assignment.setDateFin(dateFin);
            assignment.setStatut(AssignmentStatus.TERMINEE);
            return assignmentRepository.save(assignment);
        }
        throw new RuntimeException("Assignment not found");
    }

    public Long getActiveAssignmentsCount() {
        return assignmentRepository.countActiveAssignments();
    }

    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }
}
