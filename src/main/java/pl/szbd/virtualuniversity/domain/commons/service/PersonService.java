package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Person;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private UserService userService;

    public Person getPerson(String pesel) {
        return personRepository.findOne(pesel);
    }

    public Person getPersonByUsername(String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return personRepository.findOne(user.getPersonId());
        } else {
            return null;
        }
    }
}
