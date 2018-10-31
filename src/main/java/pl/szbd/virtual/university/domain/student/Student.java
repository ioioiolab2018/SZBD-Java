package pl.szbd.virtual.university.domain.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class Student {
    private static final Logger logger = LoggerFactory.getLogger(Student.class);
}
