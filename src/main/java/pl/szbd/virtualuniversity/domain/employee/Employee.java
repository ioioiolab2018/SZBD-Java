package pl.szbd.virtualuniversity.domain.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.szbd.virtualuniversity.domain.employee.model.QuestionnaireView;
import pl.szbd.virtualuniversity.domain.employee.service.EmployeeQuestionnaireService;


@RestController
@RequestMapping("/api/employee")
public class Employee {
    private static final Logger logger = LoggerFactory.getLogger(Employee.class);
    @Autowired
    private EmployeeQuestionnaireService questionnaireService;

    @GetMapping("/questionnaire/{questionnaireId}")
    public QuestionnaireView getEmployeeQuestionnaire(@PathVariable Long questionnaireId) {

        return questionnaireService.getEmployeeQuestionnairesById(questionnaireId);
    }
}
