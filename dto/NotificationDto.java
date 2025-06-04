package dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class NotificationDto {
    private Long id;

    @NotNull(message = "L'utilisateur est obligatoire")
    private Long userId;

    @NotBlank(message = "Le message est obligatoire")
    private String message;

    @NotNull(message = "Le type de notification est obligatoire")
    private String type;

    private Boolean isRead;
    private LocalDateTime createdAt;
}

