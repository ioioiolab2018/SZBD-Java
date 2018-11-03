package pl.szbd.virtual.university.domain.commons.repository;

import org.springframework.data.repository.CrudRepository;
import pl.szbd.virtual.university.domain.commons.model.entities.Student;

public interface StudentRepository extends CrudRepository<Student, String> {

}
