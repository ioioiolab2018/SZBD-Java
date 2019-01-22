package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Person;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.repository.UserRepository;

import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User createUser(Person person){
        Random random= new Random();
        String username= person.getName().toLowerCase()+person.getSurname().toLowerCase()+ random.nextInt(100);
        String password="qwerty"+random.nextInt(999);
        User newUser= new User(person.getPesel(), username,password, null);
        userRepository.save(newUser);
        return newUser;
    }
}
