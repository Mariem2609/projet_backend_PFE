package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "departements")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departement")
    private Long idDepartement;

    @NotBlank
    @Column(name = "nom_departement", unique = true, nullable = false, length = 100)
    private String nomDepartement;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Equipement> equipements;

    // Constructeurs
    public Departement() {}

    public Departement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    // Getters et Setters
    public Long getIdDepartement() { return idDepartement; }
    public void setIdDepartement(Long idDepartement) { this.idDepartement = idDepartement; }

    public String getNomDepartement() { return nomDepartement; }
    public void setNomDepartement(String nomDepartement) { this.nomDepartement = nomDepartement; }

    public List<Equipement> getEquipements() { return equipements; }
    public void setEquipements(List<Equipement> equipements) { this.equipements = equipements; }
}
