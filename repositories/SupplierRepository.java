package repositories;

import org.springframework.stereotype.Repository;
import entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

    @Repository
    public interface SupplierRepository extends JpaRepository<Supplier, Long> {

        List<Supplier> findByNomContainingIgnoreCase(String nom);

        @Query("SELECT s FROM Supplier s WHERE s.nom LIKE %:keyword% OR s.contact LIKE %:keyword% OR s.email LIKE %:keyword%")
        List<Supplier> searchByKeyword(String keyword);
}
