package dto;

public class TechnicienResponseDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String specialite;
    private String nomDepartement;
    private int interventionsEnCours;
    private int totalInterventions;
    private boolean disponible;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }
    public String getNomDepartement() { return nomDepartement; }
    public void setNomDepartement(String nomDepartement) { this.nomDepartement = nomDepartement; }
    public int getInterventionsEnCours() { return interventionsEnCours; }
    public void setInterventionsEnCours(int interventionsEnCours) { this.interventionsEnCours = interventionsEnCours; }
    public int getTotalInterventions() { return totalInterventions; }
    public void setTotalInterventions(int totalInterventions) { this.totalInterventions = totalInterventions; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
