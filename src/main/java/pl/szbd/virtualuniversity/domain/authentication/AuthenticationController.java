package pl.szbd.virtualuniversity.domain.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.szbd.virtualuniversity.config.TokenProvider;
import pl.szbd.virtualuniversity.domain.authentication.model.LoginUser;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Person;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.service.PersonService;
import pl.szbd.virtualuniversity.domain.commons.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationManager authenticationManager;
    private final TokenProvider jwtTokenUtil;
    private final PersonService personService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, TokenProvider jwtTokenUtil, PersonService personService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.personService = personService;
    }

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser user) throws AuthenticationException {
        Person person = personService.getPersonByUsername(user.getUsername());
        if (person != null) {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtil.generateToken(authentication);
            return ResponseEntity.ok(new pl.szbd.virtualuniversity.domain.authentication.model.Authentication(user.getUsername(), token, person.getRole().toString()));
        }
        return ResponseEntity.ok(null);
    }

}
