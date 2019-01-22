package pl.szbd.virtualuniversity.domain.authentication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Person;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.repository.UserRepository;
import pl.szbd.virtualuniversity.domain.commons.service.PersonService;

import java.util.*;

@Service()
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;
//    private final PersonService personService;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {//}, PersonService personService) {
        this.userRepository = userRepository;
//        this.personService = personService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        logger.debug(user.toString());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private List<SimpleGrantedAuthority> getAuthority(User user) {
//        Person person = personService.getPerson(user.getPersonId());
//        logger.debug(person.toString());
//        Collections.singletonList(new SimpleGrantedAuthority(person.getRole().toString()))
        return new ArrayList<>();
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
