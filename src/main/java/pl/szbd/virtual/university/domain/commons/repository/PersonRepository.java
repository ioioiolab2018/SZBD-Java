package pl.szbd.virtual.university.domain.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szbd.virtual.university.domain.commons.model.entities.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

}
