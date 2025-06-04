package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "techniciens")
public class Technicien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_technicien")
    private Long idTechnicien;

    @NotBlank
    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @NotBlank
    @Column(name = "prenom", nullable = false, length = 100)
    private String prenom;

    @OneToMany(mappedBy = "technicienAssigne", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Intervention> interventions;

    // Constructeurs
    public Technicien() {}

    public Technicien(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Méthodes métier
    public List<Intervention> consulterAssignations() {
        return this.interventions;
    }

    // Getters et Setters
    public Long getIdTechnicien() { return idTechnicien; }
    public void setIdTechnicien(Long idTechnicien) { this.idTechnicien = idTechnicien; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public List<Intervention> getInterventions() { return interventions; }
    public void setInterventions(List<Intervention> interventions) { this.interventions = interventions; }

    public String getNomComplet() {
        return prenom + " " + nom;
    }
}