package pl.szbd.virtual.university.domain.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.szbd.virtual.university.domain.commons.model.entities.Person;
import pl.szbd.virtual.university.domain.commons.service.PersonService;


@RestController
@RequestMapping("/api/commons")
public class Commons {
    private static final Logger logger = LoggerFactory.getLogger(Commons.class);

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person/{pesel}", method = RequestMethod.GET)
    private Person getPerson(@PathVariable String pesel) {
        return personService.getPerson(pesel);
    }
}
