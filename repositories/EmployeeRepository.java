package repositories;

import entities.Employee;
import enums.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByMatricule(String matricule);
    Optional<Employee> findByEmail(String email);

    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByStatut(EmployeeStatus statut);

    @Query("SELECT e FROM Employee e WHERE e.nom LIKE %:keyword% OR e.prenom LIKE %:keyword% OR e.matricule LIKE %:keyword%")
    List<Employee> searchByKeyword(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId AND e.statut = :statut")
    List<Employee> findByDepartmentAndStatut(Long departmentId, EmployeeStatus statut);
}
