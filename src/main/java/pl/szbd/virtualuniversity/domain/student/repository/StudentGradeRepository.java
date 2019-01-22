package pl.szbd.virtualuniversity.domain.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.student.model.StudentGrade;

import java.util.List;

@Repository
public interface StudentGradeRepository extends JpaRepository<StudentGrade, String> {
    public List<StudentGrade> getGrades(@Param("username") String username, @Param("groupId") Long groupId);
}
