package pl.szbd.virtual.university.domain.student.repository;

import org.springframework.data.repository.CrudRepository;
import pl.szbd.virtual.university.domain.commons.Person;

public interface PersonRepository extends CrudRepository<Person, String>{

}
