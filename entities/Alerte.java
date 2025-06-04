package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertes")
public class Alerte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerte")
    private Long idAlerte;

    @NotBlank(message = "Le titre est obligatoire")
    @Column(name = "titre", nullable = false)
    private String titre;

    @NotBlank(message = "Le message est obligatoire")
    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_alerte")
    private TypeAlerte typeAlerte;

    @Enumerated(EnumType.STRING)
    @Column(name = "priorite")
    private Priorite priorite;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @Column(name = "date_lecture")
    private LocalDateTime dateLecture;

    @Column(name = "est_lue")
    private Boolean estLue = false;

    // Relations - vous pouvez ajouter selon vos besoins
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipement")
    private Equipement equipement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_intervention")
    private Intervention intervention;

    // Énumérations
    public enum TypeAlerte {
        MAINTENANCE_PREVENTIVE,
        PANNE_EQUIPEMENT,
        FIN_GARANTIE,
        INTERVENTION_URGENTE,
        EQUIPEMENT_OBSOLETE,
        RAPPEL,
        AUTRE
    }

    public enum Priorite {
        BASSE,
        NORMALE,
        HAUTE,
        CRITIQUE
    }

    // Constructeurs
    public Alerte() {
        this.dateCreation = LocalDateTime.now();
        this.estLue = false;
    }

    public Alerte(String titre, String message, TypeAlerte typeAlerte, Priorite priorite) {
        this();
        this.titre = titre;
        this.message = message;
        this.typeAlerte = typeAlerte;
        this.priorite = priorite;
    }

    // Getters et Setters
    public Long getIdAlerte() {
        return idAlerte;
    }

    public void setIdAlerte(Long idAlerte) {
        this.idAlerte = idAlerte;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TypeAlerte getTypeAlerte() {
        return typeAlerte;
    }

    public void setTypeAlerte(TypeAlerte typeAlerte) {
        this.typeAlerte = typeAlerte;
    }

    public Priorite getPriorite() {
        return priorite;
    }

    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateLecture() {
        return dateLecture;
    }

    public void setDateLecture(LocalDateTime dateLecture) {
        this.dateLecture = dateLecture;
    }

    public Boolean getEstLue() {
        return estLue;
    }

    public void setEstLue(Boolean estLue) {
        this.estLue = estLue;
        if (estLue && this.dateLecture == null) {
            this.dateLecture = LocalDateTime.now();
        }
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    // Méthodes utilitaires
    public void marquerCommeLue() {
        this.estLue = true;
        this.dateLecture = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Alerte{" +
                "idAlerte=" + idAlerte +
                ", titre='" + titre + '\'' +
                ", typeAlerte=" + typeAlerte +
                ", priorite=" + priorite +
                ", dateCreation=" + dateCreation +
                ", estLue=" + estLue +
                '}';
    }
}
