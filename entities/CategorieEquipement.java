package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "categories_equipement")
public class CategorieEquipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private Long idCategorie;

    @NotBlank
    @Column(name = "nom_categorie", unique = true, nullable = false, length = 100)
    private String nomCategorie;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Equipement> equipements;

    // Constructeurs
    public CategorieEquipement() {}

    public CategorieEquipement(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    // Getters et Setters
    public Long getIdCategorie() { return idCategorie; }
    public void setIdCategorie(Long idCategorie) { this.idCategorie = idCategorie; }

    public String getNomCategorie() { return nomCategorie; }
    public void setNomCategorie(String nomCategorie) { this.nomCategorie = nomCategorie; }

    public List<Equipement> getEquipements() { return equipements; }
    public void setEquipements(List<Equipement> equipements) { this.equipements = equipements; }
}
