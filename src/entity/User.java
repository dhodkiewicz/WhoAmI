package entity;

import java.awt.Point;

public class User {

	private Point location;
	private String Name;
	
	public User() {
		
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
