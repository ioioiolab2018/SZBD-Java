package pl.szbd.virtual.university.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.szbd.virtual.university.domain.commons.Person;
import pl.szbd.virtual.university.domain.student.service.PersonService;

import java.security.PrivateKey;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/api/student/{pesel}")
    private Person getPerson(@PathVariable String pesel){
        return personService.getPerson(pesel);
    }
}
