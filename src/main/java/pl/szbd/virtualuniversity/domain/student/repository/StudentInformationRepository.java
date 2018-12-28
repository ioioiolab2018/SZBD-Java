package pl.szbd.virtualuniversity.domain.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szbd.virtualuniversity.domain.student.model.StudentInformation;

public interface StudentInformationRepository extends JpaRepository<StudentInformation, String> {
}
