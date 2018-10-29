package pl.szbd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.szbd.controllers.SoccerService;
import pl.szbd.entity.Student;

import java.util.List;


@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    SoccerService soccerService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {

        soccerService.addBarcelonaPlayer("Xavi Hernandez", "Midfielder", 6);

        List<Student> students = soccerService.getAllTeamPlayers(1);
        for (Student student : students) {
            System.out.println("Introducing Barca student => " + student);
        }
    }
}