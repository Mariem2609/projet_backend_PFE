package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateDto {
    @NotNull(message = "L'employé est obligatoire")
    private Long employeeId;

    @NotBlank(message = "Le nom d'utilisateur est obligatoire")
    @Size(max = 50, message = "Le nom d'utilisateur ne peut pas dépasser 50 caractères")
    private String username;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
    private String password;

    private String role;
}
