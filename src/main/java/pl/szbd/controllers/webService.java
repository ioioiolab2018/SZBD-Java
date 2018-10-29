package pl.szbd.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.szbd.entity.Student;
import pl.szbd.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class webService  {
	@Autowired
	private SoccerService soccerService;

	private static final Logger logger = LoggerFactory.getLogger(StudentRepository.class);
	
	
	@RequestMapping("/")
	public Student run(@RequestParam(value="id", defaultValue= "1" )long id){
		List<Student> students = soccerService.getAllTeamPlayers(id);
		Student one = students.get(students.size()-1);
		return one;
	}
	
}
