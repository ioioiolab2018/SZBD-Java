package pl.szbd.virtualuniversity.domain.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Questionnaire;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.service.QuestionnaireAnswerService;
import pl.szbd.virtualuniversity.domain.commons.service.QuestionnaireMainService;
import pl.szbd.virtualuniversity.domain.commons.service.UserService;
import pl.szbd.virtualuniversity.domain.commons.utils.DateFormatter;
import pl.szbd.virtualuniversity.domain.employee.model.Option;
import pl.szbd.virtualuniversity.domain.employee.model.QuestionnaireView;
import pl.szbd.virtualuniversity.domain.employee.repository.EmployeeQuestionnaireRepository;
import pl.szbd.virtualuniversity.domain.student.repository.StudentQuestionnaireRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeQuestionnaireService {
    @Autowired
    private EmployeeQuestionnaireRepository questionnaireRepository;
    @Autowired
    private QuestionnaireAnswerService questionnaireAnswerService;

    public QuestionnaireView getEmployeeQuestionnairesById(Long id) {
        QuestionnaireView result = null;
        Questionnaire questionnaire = questionnaireRepository.getOne(id);
        if (questionnaire != null) {
            List<Option> options = new ArrayList<>();
            result = new QuestionnaireView(questionnaire.getName(), questionnaire.getContent(), options);
            String[] names = questionnaire.getOptions().split(";");
            for (String optionName : names) {
                options.add(new Option(optionName, Math.toIntExact(questionnaireAnswerService.countAnswers(id,optionName))));
            }
        }

        return result;
    }
}
