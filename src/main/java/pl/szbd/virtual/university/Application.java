package pl.szbd.virtual.university;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        logger.info("Application start\n" +
                "====================================================================================================" +
                "==================================================================================================\n" +
                "Application started:\n" +
                "\taddress: http://localhost:7070/\n" +
                "\tdate: " + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()) + "\n\n");
    }
}
