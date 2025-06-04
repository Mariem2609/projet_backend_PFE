package dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgencyResponseDto {
    private Long id;
    private String nom;
    private String adresse;
    private String contactAdministratif;
    private String telephone;
    private LocalDateTime createdAt;
    private int nombreEmployes;
    private int nombreEquipements;
}
