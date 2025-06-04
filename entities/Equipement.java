package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "equipements")
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipement")
    private Long idEquipement;

    @NotBlank
    @Column(name = "nom_equipement", nullable = false, length = 150)
    private String nomEquipement;

    @Column(name = "marque", length = 100)
    private String marque;

    @Column(name = "modele", length = 100)
    private String modele;

    @Column(name = "numero_serie", unique = true, length = 100)
    private String numeroSerie;

    @Enumerated(EnumType.STRING)
    @Column(name = "etat")
    private EtatEquipement etat = EtatEquipement.EN_SERVICE;

    @Column(name = "date_acquisition")
    private LocalDate dateAcquisition;

    @Column(name = "localisation", length = 200)
    private String localisation;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime dateCreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departement")
    private Departement departement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categorie")
    private CategorieEquipement categorie;

    @OneToMany(mappedBy = "equipement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Intervention> interventions;

    public enum EtatEquipement {
        EN_SERVICE("En service"),
        EN_PANNE("En panne"),
        HORS_SERVICE("Hors service"),
        STOCKE("Stocké");

        private String libelle;

        EtatEquipement(String libelle) {
            this.libelle = libelle;
        }

        public String getLibelle() {
            return libelle;
        }
    }

    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }

    // Constructeurs
    public Equipement() {}

    public Equipement(String nomEquipement, String marque, String modele) {
        this.nomEquipement = nomEquipement;
        this.marque = marque;
        this.modele = modele;
    }

    // Getters et Setters
    public Long getIdEquipement() { return idEquipement; }
    public void setIdEquipement(Long idEquipement) { this.idEquipement = idEquipement; }

    public String getNomEquipement() { return nomEquipement; }
    public void setNomEquipement(String nomEquipement) { this.nomEquipement = nomEquipement; }

    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }

    public String getModele() { return modele; }
    public void setModele(String modele) { this.modele = modele; }

    public String getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }

    public EtatEquipement getEtat() { return etat; }
    public void setEtat(EtatEquipement etat) { this.etat = etat; }

    public LocalDate getDateAcquisition() { return dateAcquisition; }
    public void setDateAcquisition(LocalDate dateAcquisition) { this.dateAcquisition = dateAcquisition; }

    public String getLocalisation() { return localisation; }
    public void setLocalisation(String localisation) { this.localisation = localisation; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    public Departement getDepartement() { return departement; }
    public void setDepartement(Departement departement) { this.departement = departement; }

    public CategorieEquipement getCategorie() { return categorie; }
    public void setCategorie(CategorieEquipement categorie) { this.categorie = categorie; }

    public List<Intervention> getInterventions() { return interventions; }
    public void setInterventions(List<Intervention> interventions) { this.interventions = interventions; }
}
