package pl.szbd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.entity.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findByTeamId(long teamId);
}
