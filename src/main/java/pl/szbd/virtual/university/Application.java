package pl.szbd.virtual.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.szbd.virtual.university.domain.student.service.PersonService;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("DZIALA!!!!");
        }
    }
