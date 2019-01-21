package pl.szbd.virtualuniversity.domain.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szbd.virtualuniversity.domain.commons.model.entities.QuestionnaireAnswer;
import pl.szbd.virtualuniversity.domain.commons.model.entities.QuestionnaireAnswerIdentity;

@Repository
public interface QuestionnaireAnswerRepository extends JpaRepository<QuestionnaireAnswer, QuestionnaireAnswerIdentity> {
    @Query(value = "SELECT COUNT(date) FROM  QUESTIONNAIRE_ANSWERS where questionnaireAnswerIdentity.questionnaireId=?")
    Long countAnswers(Long id);

    @Query(value = "SELECT COUNT(date) FROM  QUESTIONNAIRE_ANSWERS where questionnaireAnswerIdentity.questionnaireId=? and answer=? ")
    Long countAnswersForOption(Long id, String option);
}
