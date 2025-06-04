package dto;


import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;

    @NotNull(message = "L'employé est obligatoire")
    private Long employeeId;

    @NotBlank(message = "Le nom d'utilisateur est obligatoire")
    @Size(max = 50, message = "Le nom d'utilisateur ne peut pas dépasser 50 caractères")
    private String username;

    private String role;
    private Boolean isActive;
    private LocalDateTime createdAt;
}

