package pl.szbd.virtual.university.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtual.university.entity.Student;
import pl.szbd.virtual.university.entity.Team;
import pl.szbd.virtual.university.repository.StudentRepository;
import pl.szbd.virtual.university.repository.TeamRepository;


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
