package pl.szbd.virtualuniversity.domain.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.szbd.virtualuniversity.domain.student.model.StudentInformation;

import java.util.List;

public interface StudentInformationRepository extends JpaRepository<StudentInformation, String> {

    @Query
    List<StudentInformation> findFirstByStudentIndex(Long index);
}
