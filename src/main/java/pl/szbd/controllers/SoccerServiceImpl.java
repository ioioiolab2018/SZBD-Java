package pl.szbd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.entity.Student;
import pl.szbd.entity.Team;
import pl.szbd.repository.StudentRepository;
import pl.szbd.repository.TeamRepository;


@Service
public class SoccerServiceImpl implements SoccerService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeamRepository teamRepository;

	public List<Student> getAllTeamPlayers(long teamId) {
		List<Student> students = studentRepository.findByTeamId(teamId);

		return students;
	}

	public void addBarcelonaPlayer(String name, String position, int number) {
		
		Team barcelona = teamRepository.findOne(1l);
		
		Student newStudent = new Student();
		newStudent.setName(name);
		newStudent.setPosition(position);
		newStudent.setNum(number);
		newStudent.setTeam(barcelona);
		studentRepository.save(newStudent);
	}

}
