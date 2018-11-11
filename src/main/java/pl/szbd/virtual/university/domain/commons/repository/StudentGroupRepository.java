package pl.szbd.virtual.university.domain.commons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtual.university.domain.commons.model.entities.StudentGroup;

@Repository
public interface StudentGroupRepository extends CrudRepository<StudentGroup, Long> {

}
