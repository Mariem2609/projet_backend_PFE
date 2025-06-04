package entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@EqualsAndHashCode(callSuper = false)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    @NotBlank(message = "Le matricule est obligatoire")
    private String matricule;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @Column(nullable = false, unique = true, length = 100)
    @Email(message = "Format d'email invalide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    @Column(length = 20)
    private String telephone;

    @Column(length = 100)
    private String poste;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Departement department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeStatus statut = EmployeeStatus.ACTIF;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Assignment> assignments;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    public enum EmployeeStatus {
        ACTIF, INACTIF
    }
}
