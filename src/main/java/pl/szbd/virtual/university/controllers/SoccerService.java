package pl.szbd.virtual.university.controllers;

import pl.szbd.virtual.university.entity.Student;

import java.util.List;



public interface SoccerService {
	public List<Student> getAllTeamPlayers(long teamId);
	
	public void addBarcelonaPlayer(String name, String position, int number);
}
