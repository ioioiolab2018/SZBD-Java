package pl.szbd.virtual.university.domain.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szbd.virtual.university.domain.commons.model.entities.Person;
import pl.szbd.virtual.university.domain.commons.service.PersonService;

@RestController
@RequestMapping("/api/student")
public class Student {
    private static final Logger logger = LoggerFactory.getLogger(Student.class);

    @Autowired
    private PersonService personService;

    @GetMapping("/student-info/{username}")
    public Person getPersonInformation(@PathVariable String username) {
        return personService.getPersonByUsername(username);
    }
}
