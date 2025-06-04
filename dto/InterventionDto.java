package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InterventionDto {
    @NotBlank
    private String titre;

    private String description;
    private String priorite;

    @NotNull
    private Long equipementId;

    @NotNull
    private Long typeInterventionId;

    private Long technicienId;

    // Getters et Setters
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getPriorite() { return priorite; }
    public void setPriorite(String priorite) { this.priorite = priorite; }
    public Long getEquipementId() { return equipementId; }
    public void setEquipementId(Long equipementId) { this.equipementId = equipementId; }
    public Long getTypeInterventionId() { return typeInterventionId; }
    public void setTypeInterventionId(Long typeInterventionId) { this.typeInterventionId = typeInterventionId; }
    public Long getTechnicienId() { return technicienId; }
    public void setTechnicienId(Long technicienId) { this.technicienId = technicienId; }
}
