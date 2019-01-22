package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Questionnaire;
import pl.szbd.virtualuniversity.domain.commons.repository.QuestionnaireAnswerRepository;
import pl.szbd.virtualuniversity.domain.commons.repository.QuestionnaireRepository;
import pl.szbd.virtualuniversity.domain.commons.utils.DateFormatter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionnaireMainService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    @Autowired
    private QuestionnaireAnswerService questionnaireAnswerService;

    public List<TableData> getQuestionnairesLike(String name) {
        List<Questionnaire> questionnaires = questionnaireRepository.getAllByNameIsContaining(name);
        if (questionnaires != null) {
            List<TableData> result = questionnaires.stream().map(element -> new TableData(
                    element.getId(),
                    element.getName(),
                    DateFormatter.getFormatter().format(element.getStartDate()),
                    DateFormatter.getFormatter().format(element.getEndDate()),
                    ( questionnaireAnswerService.countAnswersForQuestionnairyWithId(element.getId()).toString())))
                    .collect(Collectors.toList());
            return result;
        }
        return null;

    }
}
