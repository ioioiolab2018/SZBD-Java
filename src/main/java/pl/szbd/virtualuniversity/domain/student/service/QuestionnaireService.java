package pl.szbd.virtualuniversity.domain.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Questionnaire;
import pl.szbd.virtualuniversity.domain.commons.model.entities.QuestionnaireAnswer;
import pl.szbd.virtualuniversity.domain.commons.model.entities.QuestionnaireAnswerIdentity;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.repository.QuestionnaireRepository;
import pl.szbd.virtualuniversity.domain.commons.service.QuestionnaireAnswerService;
import pl.szbd.virtualuniversity.domain.commons.service.UserService;
import pl.szbd.virtualuniversity.domain.commons.utils.DateFormatter;
import pl.szbd.virtualuniversity.domain.student.model.QuestionnaireView;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    @Autowired
    private QuestionnaireAnswerService questionnaireAnswerService;
    @Autowired
    private UserService userService;

    public QuestionnaireView getStudentQuestionnaire(Long questionnaireId, String username) {
        QuestionnaireView questionnaireView;
        User user = userService.getUserByUsername(username);
        String available;

        Questionnaire questionnaire = questionnaireRepository.findOne(questionnaireId);
        if (questionnaire == null) {
            throw new IllegalArgumentException("Nie istnieje ankieta o id=" + questionnaireId + "!");
        }

        QuestionnaireAnswer questionnaireAnswer = questionnaireAnswerService.getQuestionnaireAnswer(questionnaireId, user.getPersonId());
        available = computeAvailable(questionnaire, questionnaireAnswer);
        if (questionnaireAnswer == null) {
            questionnaireAnswer = new QuestionnaireAnswer();
            questionnaireAnswer.setQuestionnaireAnswerIdentity(new QuestionnaireAnswerIdentity(user.getPersonId(), questionnaireId));
        }

        questionnaireView = new QuestionnaireView(questionnaireAnswer.getQuestionnaireAnswerIdentity().getQuestionnaireId(),
                questionnaireAnswer.getQuestionnaireAnswerIdentity().getPersonId(), questionnaire.getName(), questionnaire.getContent(),
                Arrays.asList(questionnaire.getOptions().split(";")), questionnaireAnswer.getAnswer(),
                questionnaireAnswer.getDate(), available);
        return questionnaireView;
    }

    private String computeAvailable(Questionnaire questionnaire, QuestionnaireAnswer questionnaireAnswer) {
        String available = "F";
        try {
            Date dateToCompare = DateFormatter.getFormatter().parse(DateFormatter.getFormatter().format(new Date()));
            if (questionnaire.getSingle().equals("T") && !dateToCompare.after(questionnaire.getEndDate()) && questionnaireAnswer == null){
                available = "T";
            } else if (questionnaire.getSingle().equals("F") && !dateToCompare.after(questionnaire.getEndDate())){
                available = "T";
            }
        } catch (ParseException ignored) {
        }
        return available;
    }

    public void saveQuestionnaireAnswer(QuestionnaireAnswer questionnaireAnswer) {
        questionnaireAnswerService.saveQuestionnaireAnswer(questionnaireAnswer);
    }
}
