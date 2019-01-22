package pl.szbd.virtualuniversity.domain.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query
    Student findStudentByIndex(Long index);

    @Query
    List<Student>  getAllBy(Long index);

    @Query
    Student getFirstByPersonId(String id);

    @Procedure(name = "Update_semester")
    void update_semester(@Param("student_index") Long index);
}
