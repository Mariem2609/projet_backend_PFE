package repositories;

import entities.User;
import enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmployeeId(Long employeeId);

    List<User> findByRole(UserRole role);
    List<User> findByIsActive(Boolean isActive);

    boolean existsByUsername(String username);
}
