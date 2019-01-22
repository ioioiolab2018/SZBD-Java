package pl.szbd.virtualuniversity.domain.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.employee.model.QuestionnaireView;
import pl.szbd.virtualuniversity.domain.employee.model.StudentView;
import pl.szbd.virtualuniversity.domain.employee.service.EmployeeQuestionnaireService;
import pl.szbd.virtualuniversity.domain.employee.service.EmployeeStudentService;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class Employee {
    private static final Logger logger = LoggerFactory.getLogger(Employee.class);
    @Autowired
    private EmployeeQuestionnaireService questionnaireService;
    @Autowired
    private EmployeeStudentService employeeStudentService;

    @GetMapping("/questionnaire/{questionnaireId}")
    public QuestionnaireView getEmployeeQuestionnaire(@PathVariable Long questionnaireId) {

        return questionnaireService.getEmployeeQuestionnairesById(questionnaireId);
    }

    @GetMapping("/students")
    public List<TableData> getStudents(@RequestParam String index) {
        return employeeStudentService.findStudentsForRates(index);
    }

    @GetMapping("/student-info/{index}")
    public StudentView getStudentInfo(@PathVariable Long index) {
        System.out.println("działa");
        return employeeStudentService.findStudentForEmployee(index);
    }

}
