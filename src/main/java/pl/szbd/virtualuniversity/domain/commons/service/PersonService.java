package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Person;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.model.enums.RoleType;
import pl.szbd.virtualuniversity.domain.commons.repository.PersonRepository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserService userService;


    public Person getPerson(String pesel) {
        return personRepository.findOne(pesel);
    }

    public Person getPersonByNameAndSurnamr(String name, String surname){
        return personRepository.findPersonByNameEqualsAndSurnameEquals(name,surname);
    }

    public List<Person> getStudentsLike(String name, String surname, RoleType roleType){
        return personRepository.findAllByNameIsContainingOrSurnameIsContainingAndRole(name, surname, RoleType.STUDENT);
    }

    public Person getPersonByUsername(String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return personRepository.findOne(user.getPersonId());
        } else {
            return null;
        }
    }

    public void savePerson(Person person){
        personRepository.save(person);
    }

    public User saveNewPerson(Person person) {
        personRepository.save(person);
        return userService.createUser(person);
    }
}
