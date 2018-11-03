package pl.szbd.virtual.university.domain.commons.repository;

import org.springframework.data.repository.CrudRepository;
import pl.szbd.virtual.university.domain.commons.model.entities.QuestionnaireAnswer;

public interface QuestionnaireAnswerRepository extends CrudRepository<QuestionnaireAnswer, Long> {

}
