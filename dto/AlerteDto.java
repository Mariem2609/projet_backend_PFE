package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AlerteDto{
    @NotBlank
    private String titre;

    @NotBlank
    private String message;

    @NotNull
    private String priorite;

    private Long utilisateurId;

    // Getters et Setters
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getPriorite() { return priorite; }
    public void setPriorite(String priorite) { this.priorite = priorite; }
    public Long getUtilisateurId() { return utilisateurId; }
    public void setUtilisateurId(Long utilisateurId) { this.utilisateurId = utilisateurId; }
}

