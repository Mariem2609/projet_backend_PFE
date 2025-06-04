package dto;

public class DepartementResponseDTO {
    private Long id;
    private String nom;
    private String description;
    private int nombreEquipements;
    private int nombreTechniciens;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getNombreEquipements() { return nombreEquipements; }
    public void setNombreEquipements(int nombreEquipements) { this.nombreEquipements = nombreEquipements; }
    public int getNombreTechniciens() { return nombreTechniciens; }
    public void setNombreTechniciens(int nombreTechniciens) { this.nombreTechniciens = nombreTechniciens; }
}
