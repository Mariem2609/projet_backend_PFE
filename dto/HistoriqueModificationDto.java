package dto;


import lombok.Data;
import java.time.LocalDateTime;

    @Data
    public class HistoriqueModificationDto {
        private Long idHistorique;
        private String tableModifiee;
        private Long idElement;
        private String typeOperation;
        private String donneesAvant;
        private String donneesApres;
        private LocalDateTime dateModification;
        private String utilisateurName;
    }

