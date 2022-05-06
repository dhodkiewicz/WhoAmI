/**
 * This class represents a NPC that will be randomly placed in a room for battle.
 */
package NPC;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.User;
import game.Battle;

public class Npc implements Battle{

	private Point location; 		// The location of the NPC.
	private String description; 	// The description of the NPC.
	private String message; 		// The message and NPC gives.
	private int roomID; 			// The room ID where the NPC is located.
	private double attack; 			// The amount of health user loses when hit by NPC.
	private double health;			// The NPCs health.
	private List<Point> hitPoints; 	// The hit points. (When user steps in one, it will have to battle NPC.)
	private Random rand = new Random();	// Random variable to generate a random attack in battle.
	
	/**
	 * Constructor - Set the roomID of the NPC.
	 * 
	 * @param id
	 */
	public Npc(int id) {
		setRoomID(id);
	}

	/**
	 * Constructor - sets roomID and location of an NPC.
	 * 			1.3 - Use of overloaded method/constructor.
	 * 
	 * @param id
	 * @param location
	 */
	public Npc(int id, Point location) {
		setRoomID(id);
		setLocation(location);
	}

	// Gets the location of the NPC.
	public Point getLocation() {
		return location;
	}

	// Sets the location of the NPC.
	public void setLocation(Point location) {
		this.location = location;
	}

	// Gets the description of the NPC.
	public String getDescription() {
		return description;
	}

	// Sets the description of the NPC.
	public void setDescription(String description) {
		this.description = description;
	}

	// Gets the message of the NPC.
	public String getMessage() {
		return message;
	}

	// Sets the message of the NPC.
	public void setMessage(String message) {
		this.message = message;
	}

	// Gets the roomID of the NPC.
	public int getRoomID() {
		return roomID;
	}

	// Sets the roomID of the NPC.
	public void setRoomID(int id) {
		this.roomID = id;
	}

	// Gets the attack of the NPC.
	public double getAttack() {
		return attack * this.getRoomID();
	}

	// Sets the attack of the NPC.
	public void setAttack(double attack) {
		this.attack = attack;
	}
	
	// Get random.
	public Random getRand() {
		return rand;
	}
	
	// Gets the health of the NPC.
	public double getHealth() {
		return health;
	}

	// Sets the health of the NPC.
	public void setHealth(double health) {
		this.health = health;
	}

	/**
	 *  Check if user is near the NPC.
	 * @param userLocation
	 * @return boolean
	 */
	public boolean isUserNearNpc(Point userLocation) {
		// Loop through hit points.
		for (Point p : getHitPoints()) {
			// If user location matches hit point, return true.
			if ((userLocation.x == p.x) && (userLocation.y == p.y)) {
				return true;
			}
		}
		return false;	// Return false if user location is not on a hit point.
	}
	

	/**
	 *  Gets the hit points in a bubble around the NPC.
	 * @return hitPoints
	 */
	public List<Point> getHitPoints() {
		hitPoints = new ArrayList<Point>();		// List of the NPC hit points.
		Point npcLocation = this.getLocation();	// The NPC current location.
		int x = npcLocation.x;					// The x-value of the NPCs current location.
		int y = npcLocation.y;					// The y-value of the NPCs current location.
		
		Point p1 = new Point(x+1, y-1);
		Point p2 = new Point(x+1,y);
		Point p3 = new Point(x+1, y+1);	// The points to the left of the current x-value point.
		Point p4 = new Point(x, y+1);
		Point p5 = new Point(x, y-1);	// The points above and below the current x-value point.
		Point p6 = new Point(x-1, y-1);
		Point p7 = new Point(x-1, y);
		Point p8 = new Point(x-1, y+1);	// The points to the right of the current x-value point.
		
		// Add the points to the list.
		hitPoints.add(p1);
		hitPoints.add(p2);
		hitPoints.add(p3); 
		hitPoints.add(p4);
		hitPoints.add(p5);
		hitPoints.add(p6);
		hitPoints.add(p7);
		hitPoints.add(p8);
		
		return hitPoints;	// Return list of hit points.
	}

	@Override
	public void battle(User u) {
		double userMinAttack = u.getWeaponStats() / 2;	// The minimum attack a user can make.
		double knightMinAttack = getAttack() / 2;		// The minimum attack a knight can make.
		
		do {
			// Get random values for the user and NPC attack.
			double userAttack = Math.round(getRand().nextDouble(userMinAttack, u.getWeaponStats()) * 100.0) / 100.0;
			double knightAttack = Math.round(getRand().nextDouble(knightMinAttack, getAttack()) * 100.0) / 100.0;
			int randMiss = (int)Math.floor(Math.random()*(10-0+1)+ 0);	// Random number to check if it's a miss.
			
			// User misses when randMiss is 3.
			if (randMiss == 3) {
				System.out.println("User misses!");
			} else {
				setHealth(getHealth() - userAttack);
				System.out.println("Npc hit! The user deals " + userAttack + " damage!");
			}

			randMiss = (int)Math.floor(Math.random()*(10-0+1)+ 0);
			
			// NPC misses when randMiss is 7.
			if (randMiss == 7) {
				System.out.println("The npc missed!");
			} else {
				u.setHealth(u.getHealth() - knightMinAttack);
				System.out.println("User hit! The npc deals " + knightMinAttack + " damage!");
			}

			System.out.println();	// Print new line for readability.

		} while (checkForWinner(u) == false);	//Loop as long as there's no winner.
		
	}

	@Override
	public boolean checkForWinner(User u) {
		// Check if user or NPC ran out of health.
		if (getHealth() <= 0 || u.getHealth() <= 0) {
			// If NPC health is out, user wins.
			if (getHealth() <= 0) {
				win();
				return true;
			}
			// If user health is out, NPC wins.
			if (u.getHealth() <= 0) {
				lose();
				return true;
			}
		}

		return false;
	}

	@Override
	public void lose() {
		System.out.println("Npc wins!");
		System.out.println("Do you want to continue? (y or n)");
		
	}

	@Override
	public void win() {
		System.out.println("User wins!");
	}

}
