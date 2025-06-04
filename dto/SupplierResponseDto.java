package dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SupplierResponseDto {
    private Long id;
    private String nom;
    private String contact;
    private String telephone;
    private String email;
    private String adresse;
    private LocalDateTime createdAt;
    private int nombreEquipements;
}
