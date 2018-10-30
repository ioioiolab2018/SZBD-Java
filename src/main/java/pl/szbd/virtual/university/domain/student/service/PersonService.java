package pl.szbd.virtual.university.domain.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtual.university.domain.commons.Person;
import pl.szbd.virtual.university.domain.student.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public Person getPerson(String pesel){
        return personRepository.findOne(pesel);
    }
}
