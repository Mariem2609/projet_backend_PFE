package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationCreateDto {
    @NotNull(message = "L'utilisateur est obligatoire")
    private Long userId;

    @NotBlank(message = "Le message est obligatoire")
    private String message;

    @NotNull(message = "Le type de notification est obligatoire")
    private String type;
}
