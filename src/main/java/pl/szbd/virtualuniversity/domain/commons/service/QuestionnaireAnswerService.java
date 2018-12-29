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
}
