package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "interventions")
public class Intervention {
    // Getters et Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_intervention")
    private Long idIntervention;

    @NotBlank
    @Column(name = "titre", nullable = false, length = 200)
    private String titre;

    @NotBlank
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private EtatIntervention statut = EtatIntervention.EN_ATTENTE;

    @Column(name = "solution", columnDefinition = "TEXT")
    private String solution;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime dateCreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipement")
    private Equipement equipement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_technicien_assigne")
    private Technicien technicienAssigne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type")
    private TypeIntervention typeIntervention;

    public enum EtatIntervention {
        EN_ATTENTE("En attente"),
        EN_COURS("En cours"),
        TERMINEE("Terminée"),
        ANNULEE("Annulée"),
        REPORTEE("Reportée");

        private String libelle;

        EtatIntervention(String libelle) {
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
    public Intervention() {}

    public Intervention(String titre, String description, Equipement equipement) {
        this.titre = titre;
        this.description = description;
        this.equipement = equipement;
    }

    // Méthodes métier
    public void assignerTechnicien(Technicien technicien) {
        this.technicienAssigne = technicien;
        this.statut = EtatIntervention.EN_COURS;
    }

    public void mettreAJourStatut(EtatIntervention nouveauStatut) {
        this.statut = nouveauStatut;
    }

}