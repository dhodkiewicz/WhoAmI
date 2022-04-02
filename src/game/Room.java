package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Npc;

public class Room {
	
	private Point dimensions; //holds the rooms outermost x,y points
	private List <Point> roomCoordinates; // list of each individual points within the room (think spaces that will hold char location, item location, etc)
	private Point startingDoor; // the starting door
	private Point endingDoor; // the ending door
	private Point userLocation; // might not need this to track user location within the room but will leave for now, could be held by user
	private List<Npc> npcs; // the list of the npcs within a room
	private int id; // room id for tracking which room the user is currently in (allows us to still use the point class instead of having to make a <a,b,c> type class
	
	public Room() { // the rooms constructor
		final int upper_bound = 60; // set upper bound for x axis and y axis of room
		final int lower_bound = 40; // set lower bound for x axis and y axis
		
		int randomValue = (int)Math.floor(Math.random()*(upper_bound-lower_bound+1)+ lower_bound); // generate random value between lower + upper bound
		Point point = new Point(); // create a new point which will hold random generated outer bound x,y values
		this.dimensions = point; // instantiate this objects dimensions property with a blank point
		dimensions.x = randomValue; // set the dimensions to the random generated value for x
		randomValue = (int)Math.floor(Math.random()*(upper_bound-lower_bound+1)+ lower_bound); // generate the random value between values
		dimensions.y = randomValue; // set the dimensions for y
		
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
	
	//getter for room's id
	public int getId() {
		return id;
	}

	//setter for rooms id
	public void setId(int id) {
		this.id = id;
	}

	
	//set the doors
	public void setDoors() {
		int y = this.dimensions.y / 2;
		int x = 0; //  x and y axis- that these doors will be connected from Left to Right order
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
		List<Point> tempCoordinates= new ArrayList<Point>(); // insantiate temporary list of coordinates/points
		for (int x = 0; x < this.dimensions.x; x++){ //outer loop
			for(int y = 0; y< this.dimensions.y;y++) { //inner loop
				Point p = new Point(x,y);
				tempCoordinates.add(p); // add to temporary list
			}
		}
		this.roomCoordinates = new ArrayList<Point>(); // create instance in memory of coordinates so property roomcoordinates isn't null value
		this.roomCoordinates = tempCoordinates; // set property with temporary coordinates
	}



}
