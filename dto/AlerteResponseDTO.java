package dto;

import java.time.LocalDateTime;

public class AlerteResponseDTO {
    private Long id;
    private String titre;
    private String message;
    private String priorite;
    private boolean lue;
    private LocalDateTime dateCreation;
    private String nomUtilisateur;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getPriorite() { return priorite; }
    public void setPriorite(String priorite) { this.priorite = priorite; }
    public boolean isLue() { return lue; }
    public void setLue(boolean lue) { this.lue = lue; }
    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }
    public String getNomUtilisateur() { return nomUtilisateur; }
    public void setNomUtilisateur(String nomUtilisateur) { this.nomUtilisateur = nomUtilisateur; }
}
