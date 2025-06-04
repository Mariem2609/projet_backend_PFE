package dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponseDto {
    private Long id;
    private String userName;
    private String message;
    private String type;
    private Boolean isRead;
    private LocalDateTime createdAt;
    private String tempsEcoule;
}
