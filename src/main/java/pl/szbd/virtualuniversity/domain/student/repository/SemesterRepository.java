package pl.szbd.virtualuniversity.domain.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.student.model.Semester;

import java.util.List;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
    public List<Semester> getSemesters(@Param("username") String username);
}
