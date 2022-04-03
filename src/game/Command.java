package game;

import java.util.Scanner;

import entity.User;

public interface Command {

	
	public void moveNorth();
	public void moveSouth();
	public void moveWest();
	public void moveEast();
	public void use();
	public void grab();
	
	public void determineMove(String s);
	



}
