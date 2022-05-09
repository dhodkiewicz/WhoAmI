package game;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import NPC.Npc;
import entity.Backpack;
import entity.User;
import item.Item;
import item.Key;

public class Game implements Command {

	private List<Room>rooms; //field for our list of
	private Room currentRoom; // the current room user is in
	private static User user; //field for our user
	private boolean isGameOver; //field to check if game is over or not

	public Game() throws CloneNotSupportedException { // constructor for game will autopopulate rooms (for now) -- next will establish method(s) to link doors/rooms together
		this.setGameOver(false);
		User user = new User();
		Backpack bp = new Backpack();
		User.setBackpack(bp);
		List<Room> rooms = new ArrayList<Room>();
		Room roomOne= new Room(1); // instantiate a room
		Room roomTwo= new Room(2); // instantiate a room
		Room roomThree= new Room(3); // instantiate a room
		Room roomFour= new Room(4); // instantiate a room
		roomOne.setDoors();
		user.setLocation(roomOne.getStartingDoor()); // instantiate user and set their starting position to initial "door"
		this.currentRoom = roomOne;
		Game.user = user; // set to our field
		rooms.add(roomOne);
		roomTwo.setDoors();
		rooms.add(roomTwo);
		roomThree.setDoors();
		rooms.add(roomThree);
		roomFour.setDoors();
		rooms.add(roomFour);
		this.rooms = rooms;

		Command.hello();
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
		Game.user = user;
	}


	@Override
	public void use() {
		// TODO Auto-generated method stub

	}


	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}


	@Override
	public void determineMove() throws Exception{

		if(isUserNearDoor()) { nearDoorActivity(); }

		Item i = isUserNearItem();
		if(getItemNearPlayer(i)) { itemInteraction(i); }

		npcAction();

		genericMessage();
	}


	public static boolean getItemNearPlayer(Item i){
		if(i == null)
		return false;
		else {
			return true;
		}
	}

	public boolean isValidEquipCommand(String s) {
		if(s == "y" | s == "n") {
			return true;
		}
		return false;
	}

public void genericMessage() {

	boolean flag = false;
	boolean doesUserHaveFlashlight = false;


	System.out.println("Please enter a command:");
	Scanner in = new Scanner(System.in);
	String s = in.nextLine();

	this.getUser();
	for(Item i : User.getBackpack().getBPContents()) {

				try {
					if(i.getType().equals("Flashlight")) {
					doesUserHaveFlashlight = true;
					}
				} catch (CloneNotSupportedException e) {
					System.out.println(e);
				}
	}

	if(s.equals("light") && doesUserHaveFlashlight) {
		System.out.println("I have the light! :)");
	}

	for (ValidCommands vc: ValidCommands.values()) {

		if(s.equals(vc.getCommand())) {
			flag = true;
			moveUser(s);
		}
	}
	if (!flag) {
		 System.out.println(s + " is not a valid command!");
	}
}



public void moveUser(String s) {
	int xValue;
	int yValue;
	User tempUser = new User();
	tempUser = this.getUser();
	Point tempPoint = new Point();
	tempPoint = Game.user.getLocation();
	xValue = tempPoint.x;
	yValue = tempPoint.y;
	if(s.equals("move north")){
		if(yValue == this.getCurrentRoom().getDimensions().y) {
			System.out.println("bump, you hit a wall!");
			return;
		}
		tempPoint.setLocation(xValue, yValue + 1);
		System.out.println("You moved north");
	}
	if(s.equals("move south")){
		if(yValue == 0) {
			System.out.println("bump, you hit a wall!");
			return;
		}
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
		if(xValue == this.getCurrentRoom().getDimensions().x) {
			System.out.println("bump, you hit a wall!");
			return;
		}
		tempPoint.setLocation(xValue + 1, yValue);
		System.out.println("You moved east");
	}
	tempUser.setLocation(tempPoint);
	Game.user = tempUser;
  }

public Room getCurrentRoom() {
	return currentRoom;
}

public void setCurrentRoom(Room currentRoom) {
	this.currentRoom = currentRoom;
}

public Item isUserNearItem() {
	Room r = getCurrentRoom();

	for(Item i : r.getRoomItems()) {
		Point p = i.getLocation();
		for(Point point :getPointsAroundUser()) {
			if(point.equals(p)) {
				return i;
			}
		}
	}
	return null;
}

public void itemInteraction(Item i) throws Exception {
	System.out.println("User is near a " + i.getType() + " would you like to pick it up? Enter y/n");
	Scanner in = new Scanner(System.in);
	String s = in.nextLine();
	if(s.equals("y")) {
		User.getBackpack().addItem(i);
		getCurrentRoom().getRoomItems().remove(i);
		System.out.println("You picked up a " + i.getType());
		if(isItemAWeapon(i)) {
			if(doesUserHaveWeaponEquipped()) {
				isItemBetter(i);
			}
			else {
				Game.user.setEquippedWeapon(i);
				System.out.println("You auto equipped a " + i.getType());
				return;
			}
		}
	}
}

public void npcAction(){
	// Check if user is near a NPC.
	Npc n = isUserNearNpc(this.getUser().getLocation());
	if (n != null) {
		System.out.println(n.getDescription());
		System.out.println(n.getMessage());
		System.out.println("User is now locked into battle with the " + n.getName());

		int winner = n.battle(getUser());	// The user is in battle with the NPC and returns an int to determine the winner.

		// User doesn't have equipped weapon.
		if (winner == 0) {
			// TODO - Come back to this
		}

		// User wins if winner variable is 1.
		if (winner == 1) {
			n.win();
			getCurrentRoom().getNpcs().remove(n);
			// End game here?
		}

		// User loses if winner variable is 2.
		if (winner == 2) {
			n.lose();
			if(getCurrentRoom().getId() == 4) {
				System.out.println("Do you want to play again? (y or n)");
			}

		}
	}
}

		/**
		 *  Check if user is near the NPC.
		 * @param userLocation
		 * @return boolean
		 */
		public Npc isUserNearNpc(Point userLocation) {

			for(Npc npc : this.currentRoom.getNpcs()) {
				for(Point p : npc.hitPointsSupplier().get()) {
					if ((userLocation.x == p.x) && (userLocation.y == p.y)) {
						return npc;
					}
				}
			}

			return null;
		}



public boolean isUserNearDoor() {
	for (Point p: getPointsAroundUser()) {
		if(p.equals(this.currentRoom.getEndingDoor())) {
			return true;
		}
	}
	return false;
}


public boolean doesUserHaveKeyForEndingDoor() {
	for(Item i: User.getBackpack().getBPContents()) {
		if(i.getClass() == Key.class) {
			if(i.getRoomId() == this.currentRoom.getId()) {
				return true;
			}
		}
	}
	return false;
}

public boolean doesUserHaveWeaponEquipped() {
	if (Game.user.getEquippedWeapon() == null) {
		return false;
	}
	return true;
}

//get all the points in a bubble around the user
public List<Point> getPointsAroundUser(){
	List<Point> points = new ArrayList<Point>();
	Point p5 = Game.user.getLocation();
	int x = p5.x;
	int y = p5.y;

	Point p1 = new Point(x-1, y-1);
	Point p2 = new Point(x, y-1);
	Point p3 = new Point(x + 1, y-1);
	Point p4 = new Point(x - 1, y);
	Point p6 = new Point(x + 1, y);
	Point p7 = new Point(x - 1, y + 1);
	Point p8 = new Point(x, y + 1);
	Point p9 = new Point(x + 1, y + 1);

	// add them all to the temporary list
	points.add(p1);
	points.add(p2);
	points.add(p3);
	points.add(p4);
	points.add(p5);
	points.add(p6);
	points.add(p7);
	points.add(p8);
	points.add(p9);

	// return the list
	return points;
}

public void isItemBetter(Item i) {
	System.out.println("Your current weapon is " + ((Item) Game.user.getEquippedWeapon()).getDescription());
	System.out.println("Would you like to replace it with " + i.getDescription() + "? y/n");
	Scanner in = new Scanner(System.in);
	String string = in.nextLine();
	if(string.equals("y")) {
		Game.user.setEquippedWeapon(i);
		this.currentRoom.getRoomItems().remove(i);
		System.out.println("you equipped " + i.getDescription() + " with an attack of " + Game.user.getWeaponStats());
		return;
	}
	if(string.equals("n")) {
		System.out.println("You kept your " + ((Item) Game.user.getEquippedWeapon()).getDescription());
		return;
	}

	else {
		isItemBetter(i);
	}
}

public boolean isItemAWeapon(Item i) throws CloneNotSupportedException {
	if(i.getType() == "Axe" |i.getType() == "Sword" | i.getType() == "Longsword" ) {
		return true;
	}
	return false;
}

public void nearDoorActivity() {
	String msg = "User is near the ending door, would you like to go through? y/n";
	System.out.println(msg);
	Scanner in = new Scanner(System.in);
	String s = in.nextLine();
	if(s.equals("y")) {
		if(doesUserHaveKeyForEndingDoor()) {
			this.currentRoom = getRooms().get(this.currentRoom.getId());
			Game.user.setLocation(this.currentRoom.getStartingDoor());
			System.out.println("You moved into room " + this.currentRoom.getId());
			return;
		}
		else {
			System.out.println("Sorry you don't have the key for Room " + this.currentRoom.getId());
			return;
		}
	}
}


}
