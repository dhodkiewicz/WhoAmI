package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import item.Axe;
import item.Flashlight;
import item.HealthPotion;
import item.Item;

import item.Key;
import item.Longsword;
import item.Shortsword;
import NPC.Goblin;
import NPC.Knight;
import NPC.Npc;
import NPC.Pirate;

public class Room {
	
	private Point dimensions; //holds the rooms outermost x,y points
	private List <Point> roomCoordinates; // list of each individual points within the room (think spaces that will hold char location, item location, etc)
	private Point startingDoor; // the starting door
	private Point endingDoor; // the ending door
	private Point userLocation; // might not need this to track user location within the room but will leave for now, could be held by user
	private List<Npc> npcs; // the list of the npcs within a room
	private int id; // room id for tracking which room the user is currently in (allows us to still use the point obj instead of having to make a <a,b,c> type class
	private List<Item>roomItems; // field for holding the list of items in the room
	
	
	public Room(int id) { // the rooms constructor
		this.id = id;
		final int upper_bound = 40; // set upper bound for x axis and y axis of room
		final int lower_bound = 30; // set lower bound for x axis and y axis
		
		int randomValue = (int)Math.floor(Math.random()*(upper_bound-lower_bound+1)+ lower_bound); // generate random value between lower + upper bound
		Point point = new Point(); // create a new point which will hold random generated outer bound x,y values
		this.dimensions = point; // instantiate this objects dimensions property with a blank point
		dimensions.x = randomValue; // set the dimensions to the random generated value for x
		randomValue = (int)Math.floor(Math.random()*(upper_bound-lower_bound+1)+ lower_bound); // generate the random value between values
		dimensions.y = randomValue; // set the dimensions for y
		
		populateRoomCoordinates(); // populate room coordinates upon instantiation
		createRoomItems(id);
		createRoomNpcs(id);	// Create the NPCs for the room.
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
	
	
	public List<Item> getRoomItems() {
		return roomItems;
	}

	public void setRoomItems(List<Item> roomItems) {
		this.roomItems = roomItems;
	}

	public void createRoomItems(int id) {
		HealthPotion hp = new HealthPotion(id);
		Axe axe = new Axe(id);
		Longsword ls = new Longsword(id);
		Shortsword sw = new Shortsword(id);
		Flashlight fl = new Flashlight(id);
		Key key = new Key(id);
		
		
		this.roomItems = new ArrayList<Item>();
		
		this.roomItems.add(hp); //
		this.roomItems.add(axe);
		this.roomItems.add(ls);
		this.roomItems.add(sw);
		this.roomItems.add(fl);
		this.roomItems.add(key);
		
		for(Item i: this.roomItems) {
			List<Point>coordinates = getRoomCoordinates(); // get the rooms coordinates
			int randomValue = (int)Math.floor(Math.random()*(getRoomCoordinates().size())); // random value between 0 and room coords max length
			Point p = coordinates.get(randomValue); // set a point equal to the random value index of the rooms coordinates
			i.setLocation(p);
			System.out.println(i.getClass());
		}
		
		System.out.println("Here");
	}
	
	/**
	 * This method creates the NPCs in a specific room.
	 * @param id
	 */
	public void createRoomNpcs(int id) {
		Goblin g = new Goblin(id);
		Knight k = new Knight(id);
		Pirate p = new Pirate(id);
		
		this.npcs = new ArrayList<Npc>();	// Create new instance of array list to hold npcs.
		
		// Add NPCs to array list.
		this.npcs.add(g);
		this.npcs.add(k);
		this.npcs.add(p);
		
		// Set the location of the NPCs.
		for (Npc n : this.npcs) {
			List<Point> coordinates = getRoomCoordinates();	// The room coordinates.
			int randValue = (int)Math.floor(Math.random()* (coordinates.size()));
			Point pt = coordinates.get(randValue);
			n.setLocation(pt);
			
			// TODO  - Remove this after testing is complete.
			System.out.println(n.getClass());
			System.out.println(n.getLocation());
		}
	}

}
