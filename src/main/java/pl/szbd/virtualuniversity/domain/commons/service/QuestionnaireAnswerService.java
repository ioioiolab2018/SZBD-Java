package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.QuestionnaireAnswer;
import pl.szbd.virtualuniversity.domain.commons.model.entities.QuestionnaireAnswerIdentity;
import pl.szbd.virtualuniversity.domain.commons.repository.QuestionnaireAnswerRepository;

@Service
public class QuestionnaireAnswerService {
    @Autowired
    private QuestionnaireAnswerRepository questionnaireAnswerRepository;

    public QuestionnaireAnswer getQuestionnaireAnswer(Long questionnaireId, String personId) {
        return questionnaireAnswerRepository.findOne(new QuestionnaireAnswerIdentity(personId, questionnaireId));
    }

    public void saveQuestionnaireAnswer(QuestionnaireAnswer questionnaireAnswer) {
        questionnaireAnswerRepository.save(questionnaireAnswer);
    }

    public Long countAnswersForQuestionnairyWithId(Long id) {
        Long count =questionnaireAnswerRepository.countAnswers(id);
        if(count != null){
            return count;
        }else return 0L;
    }

    public Long countAnswers(Long id, String option) {
        Long count =questionnaireAnswerRepository.countAnswersForOption(id,option);
        if(count != null){
            return count;
        }else return 0L;
    }



}
