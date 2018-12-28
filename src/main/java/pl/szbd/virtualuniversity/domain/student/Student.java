package pl.szbd.virtualuniversity.domain.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szbd.virtualuniversity.domain.student.model.StudentInformation;
import pl.szbd.virtualuniversity.domain.student.service.StudentInformationService;

@RestController
@RequestMapping("/api/student")
public class Student {
    private static final Logger logger = LoggerFactory.getLogger(Student.class);

    @Autowired
    private StudentInformationService studentInformationService;

    @GetMapping("/student-info/{username}")
    public StudentInformation getPersonInformation(@PathVariable String username) {
        return studentInformationService.getStudentInformationByUsername(username);
    }
}
