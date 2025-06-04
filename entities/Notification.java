package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@EqualsAndHashCode(callSuper = false)
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "L'utilisateur est obligatoire")
    private User user;

    @Column(nullable = false, columnDefinition = "TEXT")
    @NotBlank(message = "Le message est obligatoire")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Le type de notification est obligatoire")
    private NotificationType type;

    @Column(name = "is_read", nullable = false)
    private Boolean isRead = false;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public enum NotificationType {
        GARANTIE, AFFECTATION, MAINTENANCE
    }
}