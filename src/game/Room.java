package game;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import entity.Npc;

public class Room {
	
	private Point dimensions;
	private Point startingDoor;
	private Point endingDoor;
	private Point userLocation;
	private List<Npc> npcs;
	
	public Room() {
		Random rand = new Random();
		final int upper_bound = 60; // set upper bound for x axis and y axis of room
		final int lower_bound = 40; // set lower bound for x axis and y axis
		
		int randomValue = (int)Math.floor(Math.random()*(upper_bound-lower_bound+1)+ lower_bound);
		Point point = new Point();
		this.dimensions = point;
		dimensions.x = randomValue;
		randomValue = (int)Math.floor(Math.random()*(upper_bound-lower_bound+1)+ lower_bound);
		dimensions.y = randomValue;
		
	}
	
	//get door
	public Point getStartingDoor() {
		return startingDoor;
	}
	//set door
	public void setStartingDoor(Point startingDoor) {
		this.startingDoor = startingDoor;
	}
	//get ending door point
	public Point getEndingDoor() {
		return endingDoor;
	}
	
	//set ending door point
	public void setEndingDoor(Point endingDoor) {
		this.endingDoor = endingDoor;
	}
	
	// get Room Dimensions
	public Point getDimensions() {
		return dimensions;
	}

	//set Room Dimensions
	public void setDimensions(Point dimensions) {
		this.dimensions = dimensions;
	}

	//get userLocation
	public Point getUserLocation() {
		return userLocation;
	}
	
	//Set user location
	public void setUserLocation(Point userLocation) {
		this.userLocation = userLocation;
	}

	//get list of NPC's
	public List<Npc> getNpcs() {
		return npcs;
	}

	//Set List of NPC's
	public void setNpcs(List<Npc> npcs) {
		this.npcs = npcs;
	}

}
