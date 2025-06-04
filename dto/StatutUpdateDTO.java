package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StatutUpdateDTO {
    @NotNull
    private String statut;

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}

