package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Npc;

public class Room {
	
	private Point dimensions;
	private List <Point> roomCoordinates;
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
		
		populateRoomCoordinates(); // populate room coordinates upon instantiation
		
	}
	
	/////////////////////////////////////////////////////////DOOR METHODS START//////////////////////////////////////////////////////////////////////////////
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
	
	//set the doors
	public void setDoors() {
		int y = this.dimensions.y / 2;
		int x = 0; // for now pretend on x and y axis- that these doors will be connected from Left to Right order
		Point door = new Point(x,y); // create starting point for room
		this.startingDoor = door;
		
		y = this.dimensions.y / 2; // setting y coordinate to be half the rooms dimension on y axis- so doors will be in the middle of room y- axis wall
		x = this.dimensions.x - 1; // this will set the x coordinate for the end door to the farthest right of the room (in theory)
		door = new Point(x,y);
		this.endingDoor = door; // now set ending door
		
		
	}

	// retrieve the rooms coordinates
	public List <Point> getRoomCoordinates() {
		return roomCoordinates;
	}
	
	//method to populate room coordinates
	public void populateRoomCoordinates() {
		List<Point> tempCoordinates= new ArrayList<Point>();
		for (int x = 0; x < this.dimensions.x; x++){
			for(int y = 0; y< this.dimensions.y;y++) {
				Point p = new Point(x,y);
				tempCoordinates.add(p);
			}
		}
		this.roomCoordinates = new ArrayList<Point>(); // create instance in memory of coordinates so roomcoordinates isn't null value
		this.roomCoordinates = tempCoordinates; // instantiate property with temporary coordinates
	}


}
