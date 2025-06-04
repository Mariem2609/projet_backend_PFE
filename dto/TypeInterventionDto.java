package dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class TypeInterventionDto {
    private Long idType;

    @NotBlank(message = "Le nom du type d'intervention est obligatoire")
    @Size(max = 100, message = "Le nom ne peut pas dépasser 100 caractères")
    private String nomType;
}

