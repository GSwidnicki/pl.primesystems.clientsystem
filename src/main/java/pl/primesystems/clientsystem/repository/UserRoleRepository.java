package pl.primesystems.clientsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.primesystems.clientsystem.entity.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRole(String role);
}
