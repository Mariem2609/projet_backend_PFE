package dto;

import jakarta.validation.constraints.NotBlank;

public class DepartementDto {
    @NotBlank
    private String nom;
    private String description;

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

