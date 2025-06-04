package dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class CategorieEquipementDto {
    private Long idCategorie;

    @NotBlank(message = "Le nom de la catégorie est obligatoire")
    @Size(max = 100, message = "Le nom ne peut pas dépasser 100 caractères")
    private String nomCategorie;
}

