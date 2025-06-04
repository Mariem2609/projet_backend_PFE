package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Long idUtilisateur;

    @NotBlank
    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Email
    @NotBlank
    @Column(name = "email", unique = true, nullable = false, length = 150)
    private String email;

    @NotBlank
    @Column(name = "mot_de_passe", nullable = false, length = 100)
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RoleUtilisateur role;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime dateCreation;

    public enum RoleUtilisateur {
        ADMIN, TECHNICIEN
    }

    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }

    // Constructeurs
    public Utilisateur() {}

    public Utilisateur(String nom, String email, String motDePasse, RoleUtilisateur role) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    // Getters et Setters
    public Long getIdUtilisateur() { return idUtilisateur; }
    public void setIdUtilisateur(Long idUtilisateur) { this.idUtilisateur = idUtilisateur; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public RoleUtilisateur getRole() { return role; }
    public void setRole(RoleUtilisateur role) { this.role = role; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }
}