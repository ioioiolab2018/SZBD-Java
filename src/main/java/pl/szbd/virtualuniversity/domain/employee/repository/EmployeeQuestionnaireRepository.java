package pl.szbd.virtualuniversity.domain.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Questionnaire;
import pl.szbd.virtualuniversity.domain.student.model.StudentQuestionnaire;

import java.util.List;

public interface EmployeeQuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

    @Query
    Questionnaire findById(Long id);
}
