package dto;


import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AgencyCreateDto {
    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 100, message = "Le nom ne peut pas dépasser 100 caractères")
    private String nom;

    private String adresse;

    @Size(max = 100, message = "Le contact administratif ne peut pas dépasser 100 caractères")
    private String contactAdministratif;

    @Size(max = 20, message = "Le téléphone ne peut pas dépasser 20 caractères")
    private String telephone;
}

