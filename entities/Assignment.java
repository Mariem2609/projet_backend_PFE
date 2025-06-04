package entities;

import enums.AssignmentStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "assignments")
@Data
@EqualsAndHashCode(callSuper = false)
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id", nullable = false)
    @NotNull(message = "L'équipement est obligatoire")
    private Equipement equipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    @NotNull(message = "L'employé est obligatoire")
    private Employee employee;

    @Column(name = "date_debut", nullable = false)
    @NotNull(message = "La date de début est obligatoire")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssignmentStatus statut = AssignmentStatus.ACTIVE;

    @Column(columnDefinition = "TEXT")
    private String observations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_by_manager")
    private Employee approvedByManager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_by_admin")
    private Employee approvedByAdmin;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public void setStatut(enums.AssignmentStatus assignmentStatus) {
    }

    public enum AssignmentStatus {
        ACTIVE, TERMINEE
    }
}