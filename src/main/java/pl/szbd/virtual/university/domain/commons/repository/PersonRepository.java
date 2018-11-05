package pl.szbd.virtual.university.domain.commons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtual.university.domain.commons.model.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

}
