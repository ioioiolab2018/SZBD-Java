package pl.szbd.virtualuniversity.domain.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.QuestionnaireAnswer;
import pl.szbd.virtualuniversity.domain.student.model.QuestionnaireView;
import pl.szbd.virtualuniversity.domain.student.model.StudentInformation;
import pl.szbd.virtualuniversity.domain.student.service.QuestionnaireService;
import pl.szbd.virtualuniversity.domain.student.service.StudentInformationService;
import pl.szbd.virtualuniversity.domain.student.service.StudentQuestionnaireService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class Student {
    private static final Logger logger = LoggerFactory.getLogger(Student.class);

    @Autowired
    private StudentInformationService studentInformationService;
    @Autowired
    private StudentQuestionnaireService studentQuestionnaireService;
    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/student-info/{username}")
    public StudentInformation getStudentInformation(@PathVariable String username) {
        return studentInformationService.getStudentInformationByUsername(username);
    }

    @GetMapping("/questionnaires/{username}")
    public List<TableData> getStudentQuestionnaires(@PathVariable String username, @RequestParam(value = "filter", required = false) String filter) {
        return studentQuestionnaireService.getStudentQuestionnaires(username, filter);
    }

    @GetMapping("/questionnaire/{questionnaireId}")
    public QuestionnaireView getStudentQuestionnaires(@PathVariable Long questionnaireId, @RequestParam(value = "student", required = false) String username) {
        return questionnaireService.getStudentQuestionnaire(questionnaireId, username);
    }

    @PostMapping(value = "/questionnaire/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void savePersonInformation(@RequestBody QuestionnaireAnswer questionnaireAnswer) {
        questionnaireService.saveQuestionnaireAnswer(questionnaireAnswer);
    }
}
