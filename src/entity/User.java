package entity;

import java.awt.Point;

public class User {

	private Point location;
	private String Name;
	private int currentRoom;
	
	public User() {
		
	}

	//getter for users location(Point <x,y>)
	public Point getLocation() {
		return location;
	}

	//setter for users location
	public void setLocation(Point location) {
		this.location = location;
	}

	//getter for current user's name
	public String getName() {
		return Name;
	}

	//setter for user's current name
	public void setName(String name) {
		Name = name;
	}

	//getter for users current room
	public int getCurrentRoom() {
		return currentRoom;
	}

	//setter for users current room
	public void setCurrentRoom(int currentRoom) {
		this.currentRoom = currentRoom;
	}

}
