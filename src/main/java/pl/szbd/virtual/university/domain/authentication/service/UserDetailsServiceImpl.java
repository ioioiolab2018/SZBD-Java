package pl.szbd.virtual.university.domain.authentication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.szbd.virtual.university.domain.commons.model.entities.Person;
import pl.szbd.virtual.university.domain.commons.model.entities.User;
import pl.szbd.virtual.university.domain.commons.repository.UserRepository;
import pl.szbd.virtual.university.domain.commons.service.PersonService;
import pl.szbd.virtual.university.domain.commons.service.UserService;

import java.util.*;

@Service(value = "userService")
public class UserDetailsServiceImpl implements UserDetailsService, UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final PersonService personService;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, PersonService personService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.personService = personService;
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
        Person person = personService.getPerson(user.getPersonId());
        logger.debug(person.toString());
        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole().toString()));
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean deleteUserByUsername(String username) {
        userRepository.delete(userRepository.findByUsername(username));
        return true;
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
