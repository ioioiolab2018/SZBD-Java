package pl.szbd.virtual.university.domain.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.szbd.virtual.university.domain.commons.model.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM APP_USERS u WHERE u.USERNAME = ?", nativeQuery = true)
    User getUserByUsername(String username);
}
