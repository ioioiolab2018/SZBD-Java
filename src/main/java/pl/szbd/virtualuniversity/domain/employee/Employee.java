package pl.szbd.virtual.university.domain.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class Employee {
    private static final Logger logger = LoggerFactory.getLogger(Employee.class);
}
