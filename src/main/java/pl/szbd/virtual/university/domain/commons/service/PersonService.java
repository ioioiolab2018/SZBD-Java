package pl.szbd.virtual.university.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtual.university.domain.commons.model.entities.Person;
import pl.szbd.virtual.university.domain.commons.repository.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPerson(String pesel) {
        return personRepository.getOne(pesel);
    }
}