package pl.szbd.virtual.university.domain.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szbd.virtual.university.domain.commons.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
