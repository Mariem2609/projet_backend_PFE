package dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private Long id;
    private String employeeName;
    private String employeeMatricule;
    private String username;
    private String role;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private int nombreNotifications;
}
