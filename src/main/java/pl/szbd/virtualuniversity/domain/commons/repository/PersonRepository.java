package pl.szbd.virtualuniversity.domain.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Person;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.model.enums.RoleType;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    @Query(value = "SELECT * FROM PERSONS u WHERE u.NAME = ? AND u.SURNAME=?", nativeQuery = true)
    Person findPersonByNameEqualsAndSurnameEquals(String name, String surname);

    @Query
    List<Person> findAllByNameIsContainingOrSurnameIsContainingAndRole(String name, String surname, RoleType roleType);


}
