package dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
    public class HistoriqueModificationResponseDto {
        private Long idHistorique;
        private String tableModifiee;
        private Long idElement;
        private String typeOperation;
        private String donneesAvant;
        private String donneesApres;
        private LocalDateTime dateModification;
        private String utilisateurName;
        private String description;
        private String tempsEcoule;
    }
