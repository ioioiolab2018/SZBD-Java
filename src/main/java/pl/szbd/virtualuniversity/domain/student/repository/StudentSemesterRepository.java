package pl.szbd.virtualuniversity.domain.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.student.model.StudentSemester;

import java.util.List;

@Repository
public interface StudentSemesterRepository extends JpaRepository<StudentSemester, Long> {
    public List<StudentSemester> getSemesters(@Param("username") String username);
}
