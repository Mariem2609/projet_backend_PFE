package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historique_modifications")
public class HistoriqueModification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historique")
    private Long idHistorique;

    @NotBlank
    @Column(name = "table_modifiee", nullable = false, length = 50)
    private String tableModifiee;

    @Column(name = "id_element", nullable = false)
    private Long idElement;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_operation", nullable = false)
    private TypeOperation typeOperation;

    @Column(name = "donnees_avant", columnDefinition = "TEXT")
    private String donneesAvant;

    @Column(name = "donnees_apres", columnDefinition = "TEXT")
    private String donneesApres;

    @Column(name = "date_modification", nullable = false)
    private LocalDateTime dateModification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    public enum TypeOperation {
        INSERT, UPDATE, DELETE
    }

    @PrePersist
    protected void onCreate() {
        dateModification = LocalDateTime.now();
    }

    // Constructeurs
    public HistoriqueModification() {}

    public HistoriqueModification(String tableModifiee, Long idElement, TypeOperation typeOperation, Utilisateur utilisateur) {
        this.tableModifiee = tableModifiee;
        this.idElement = idElement;
        this.typeOperation = typeOperation;
        this.utilisateur = utilisateur;
    }

    // Getters et Setters
    public Long getIdHistorique() { return idHistorique; }
    public void setIdHistorique(Long idHistorique) { this.idHistorique = idHistorique; }

    public String getTableModifiee() { return tableModifiee; }
    public void setTableModifiee(String tableModifiee) { this.tableModifiee = tableModifiee; }

    public Long getIdElement() { return idElement; }
    public void setIdElement(Long idElement) { this.idElement = idElement; }

    public TypeOperation getTypeOperation() { return typeOperation; }
    public void setTypeOperation(TypeOperation typeOperation) { this.typeOperation = typeOperation; }

    public String getDonneesAvant() { return donneesAvant; }
    public void setDonneesAvant(String donneesAvant) { this.donneesAvant = donneesAvant; }

    public String getDonneesApres() { return donneesApres; }
    public void setDonneesApres(String donneesApres) { this.donneesApres = donneesApres; }

    public LocalDateTime getDateModification() { return dateModification; }
    public void setDateModification(LocalDateTime dateModification) { this.dateModification = dateModification; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }
}