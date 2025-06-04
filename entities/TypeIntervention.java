package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "types_intervention")
public class TypeIntervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type")
    private Long idType;

    @NotBlank
    @Column(name = "nom_type", unique = true, nullable = false, length = 100)
    private String nomType;

    @OneToMany(mappedBy = "typeIntervention", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Intervention> interventions;

    // Constructeurs
    public TypeIntervention() {}

    public TypeIntervention(String nomType) {
        this.nomType = nomType;
    }

    // Getters et Setters
    public Long getIdType() { return idType; }
    public void setIdType(Long idType) { this.idType = idType; }

    public String getNomType() { return nomType; }
    public void setNomType(String nomType) { this.nomType = nomType; }

    public List<Intervention> getInterventions() { return interventions; }
    public void setInterventions(List<Intervention> interventions) { this.interventions = interventions; }
}
