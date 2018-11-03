package pl.szbd.virtual.university.domain.commons.repository;

import org.springframework.data.repository.CrudRepository;
import pl.szbd.virtual.university.domain.commons.model.entities.StudentGroup;

public interface StudentGroupRepository extends CrudRepository<StudentGroup, Long> {

}
