package pl.szbd.controllers;

import pl.szbd.entity.Student;

import java.util.List;



public interface SoccerService {
	public List<Student> getAllTeamPlayers(long teamId);
	
	public void addBarcelonaPlayer(String name, String position, int number);
}
