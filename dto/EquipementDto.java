package dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EquipementDto {
    private Long idEquipement;

    @NotBlank(message = "Le nom de l'équipement est obligatoire")
    @Size(max = 150, message = "Le nom ne peut pas dépasser 150 caractères")
    private String nomEquipement;

    @Size(max = 100, message = "La marque ne peut pas dépasser 100 caractères")
    private String marque;

    @Size(max = 100, message = "Le modèle ne peut pas dépasser 100 caractères")
    private String modele;

    @Size(max = 100, message = "Le numéro de série ne peut pas dépasser 100 caractères")
    private String numeroSerie;

    private String etat;
    private LocalDate dateAcquisition;

    @Size(max = 200, message = "La localisation ne peut pas dépasser 200 caractères")
    private String localisation;

    private LocalDateTime dateCreation;
    private Long departementId;
    private Long categorieId;
}

