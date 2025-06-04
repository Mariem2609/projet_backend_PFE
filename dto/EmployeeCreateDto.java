package dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeCreateDto {
    @NotBlank(message = "Le matricule est obligatoire")
    @Size(max = 20, message = "Le matricule ne peut pas dépasser 20 caractères")
    private String matricule;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 50, message = "Le nom ne peut pas dépasser 50 caractères")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    @Size(max = 50, message = "Le prénom ne peut pas dépasser 50 caractères")
    private String prenom;

    @Email(message = "Format d'email invalide")
    @NotBlank(message = "L'email est obligatoire")
    @Size(max = 100, message = "L'email ne peut pas dépasser 100 caractères")
    private String email;

    @Size(max = 20, message = "Le téléphone ne peut pas dépasser 20 caractères")
    private String telephone;

    @Size(max = 100, message = "Le poste ne peut pas dépasser 100 caractères")
    private String poste;

    private Long departmentId;
    private Long agencyId;
}
