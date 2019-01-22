package pl.szbd.virtualuniversity.domain.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.szbd.virtualuniversity.domain.student.model.StudentQuestionnaire;

import java.util.List;

public interface StudentQuestionnaireRepository extends JpaRepository<StudentQuestionnaire, Long> {

    @Query(value = "SELECT sq.id, sq.name, sq.start_date, sq.end_date, CASE\n" +
            "WHEN sq.available = 'Y' AND NOT EXISTS (SELECT '1' FROM questionnaire_answers t_qa WHERE t_qa.person_id = ? " +
                "AND t_qa.questionnaire_id = sq.id) AND sysdate < sq.end_date THEN 'T'\n" +
            "WHEN sq.available = 'F' AND sysdate < sq.end_date THEN 'T'\n" +
            "ELSE 'F'\nEND as available FROM STUDENT_QUESTIONNAIRES sq", nativeQuery = true)
    List<StudentQuestionnaire> getStudentQuestionnaires(String personId);
}
