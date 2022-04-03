package game;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.User;

public class Game implements Command {

	private List<Room>rooms; //field for our list of
	private Room currentRoom; // the current room user is in
	private User user; //field for our user
	private boolean isGameOver; //field to check if game is over or not


	
	public Game() { // constructor for game will autopopulate rooms (for now) -- next will establish method(s) to link doors/rooms together
		this.setGameOver(false);
		User user = new User();
		List<Room> rooms = new ArrayList<Room>();
		Room roomOne= new Room(); // instantiate a room
		Room roomTwo= new Room(); // instantiate a room
		Room roomThree= new Room(); // instantiate a room
		Room roomFour= new Room(); // instantiate a room
		roomOne.setId(0);
		roomOne.setDoors();
		user.setLocation(roomOne.getStartingDoor()); // instantiate user and set their starting position to initial "door"
		this.currentRoom = roomOne;
		this.user = user; // set to our field
		rooms.add(roomOne);
		roomTwo.setId(1);
		roomTwo.setDoors();
		rooms.add(roomTwo);
		roomThree.setId(2);
		roomThree.setDoors();
		rooms.add(roomThree);
		roomFour.setId(3);
		roomFour.setDoors();
		rooms.add(roomFour);
		this.rooms = rooms;
		
	}

	//getter for rooms
	public List<Room> getRooms() {
		return rooms;
	}

	//setter for rooms
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	//get user
	public User getUser() {
		return user;
	}

	//set the user
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void moveNorth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveSouth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveWest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveEast() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void grab() {
		// TODO Auto-generated method stub
		
	}

	

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	
	   public static void promptEnterKey(){
	        System.out.println("Press \"ENTER\" to continue...");
	        System.out.println();
	        System.out.println();
	        try {
	            int read = System.in.read(new byte[2]);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	@Override
	public void determineMove(String s) {
		boolean flag = false;
		for (ValidCommands vc: ValidCommands.values()) {
			if(s.equals(vc.getCommand())) {
				flag = true;
				moveUser(s);
				return;
			}
			if (!flag) {
				System.out.println("Not a valid command");
			}
			System.out.println(vc.getCommand());
		}
		
	}
	

public void moveUser(String s) {
	int xValue;
	int yValue;
	User tempUser = new User();
	tempUser = this.getUser();
	Point tempPoint = new Point();
	tempPoint = this.user.getLocation();
	xValue = tempPoint.x;
	yValue = tempPoint.y;
	if(s.equals("move north")){
		if(yValue == this.getCurrentRoom().getDimensions().y) {
			System.out.println("bump, you hit a wall!");
		}
		tempPoint.setLocation(xValue, yValue + 1);
		System.out.println("You moved north");
	}
	if(s.equals("move south")){
		tempPoint.setLocation(xValue, yValue - 1);
		System.out.println("You moved south");
	}
	if(s.equals("move west")){
		if(xValue == 0) {
			System.out.println("bump, you hit a wall!");
			return;
		}
		tempPoint.setLocation(xValue - 1, yValue);
		System.out.println("You moved west");
	}
	if(s.equals("move east")){
		tempPoint.setLocation(xValue + 1, yValue);
		System.out.println("You moved east");
	}
	tempUser.setLocation(tempPoint);
	this.user = tempUser;
  }

public Room getCurrentRoom() {
	return currentRoom;
}

public void setCurrentRoom(Room currentRoom) {
	this.currentRoom = currentRoom;
}


}
