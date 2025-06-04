package dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EquipementResponseDto {
    private Long idEquipement;
    private String nomEquipement;
    private String marque;
    private String modele;
    private String numeroSerie;
    private String etat;
    private String etatLibelle;
    private LocalDate dateAcquisition;
    private String localisation;
    private LocalDateTime dateCreation;
    private String departementName;
    private String categorieName;
    private int nombreInterventions;
}
