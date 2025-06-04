package repositories;
import entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface DepartementRepository {


    List<Departement> findAll();

    List<Departement> searchByKeyword(String keyword);

    Long countActiveEmployeesByDepartment(Long departmentId);

    Optional<Departement> findByNom(String nom);

    void deleteById(Long id);

    Departement save(Departement department);

    Optional<Departement> findById(Long id);

    Departement save();

    @Repository
    public interface DepartmentRepository extends JpaRepository<Departement, Long> {

        Optional<Departement> findByNom(String nom);

        @Query("SELECT d FROM Department d WHERE d.nom LIKE %:keyword% OR d.description LIKE %:keyword%")
        List<Departement> searchByKeyword(String keyword);

        @Query("SELECT COUNT(e) FROM Employee e WHERE e.department.id = :departmentId AND e.statut = 'ACTIF'")
        Long countActiveEmployeesByDepartment(Long departmentId);
    }
}