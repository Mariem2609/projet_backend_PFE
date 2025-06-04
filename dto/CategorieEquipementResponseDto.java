package dto;

import lombok.Data;

@Data
public class CategorieEquipementResponseDto {
    private Long idCategorie;
    private String nomCategorie;
    private int nombreEquipements;
}
