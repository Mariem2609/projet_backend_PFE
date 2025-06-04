package repositories;

import entities.Equipement;
import enums.EquipementStatus;
import enums.EquipementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {

    Optional<Equipement> findByCodeInventaire(String codeInventaire);

    List<Equipement> findByStatut(EquipementStatus statut);
    List<Equipement> findByTypeEquipement(EquipementType typeEquipement);
    List<Equipement> findBySupplierId(Long supplierId);

    @Query("SELECT e FROM Equipment e WHERE e.nom LIKE %:keyword% OR e.codeInventaire LIKE %:keyword% OR e.marque LIKE %:keyword%")
    List<Equipement> searchByKeyword(String keyword);

    @Query("SELECT e FROM Equipment e WHERE e.dateGarantieFin BETWEEN :startDate AND :endDate")
    List<Equipement> findByGarantieExpiringBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT COUNT(e) FROM Equipment e WHERE e.statut = :statut")
    Long countByStatut(EquipementStatus statut);

    @Query("SELECT e.typeEquipement, COUNT(e) FROM Equipment e GROUP BY e.typeEquipement")
    List<Object[]> countEquipmentsByType();
}
