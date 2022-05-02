/**
 * This class represents a npc that will be randomly placed in a room for battle.
 */
package NPC;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
public class Npc {

	private Point location; 		// The location of the NPC.
	private String description; 	// The description of the NPC.
	private String message; 		// The message and NPC gives.
	private int roomID; 			// The room ID where the NPC is located.
	private double attack; 			// The attack level of the NPC.
	private List<Point> hitPoints; 	// The hit points. (When user steps in one, it will have to battle NPC.)

	/**
	 * Constructor - Set the roomID of the NPC.
	 * 
	 * @param id
	 */
	public Npc(int id) {
		setRoomID(id);
	}

	/**
	 * Constructor - sets roomID and location of an NPC. 1.3 - Use of overloaded
	 * method/constructor.
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

	// Gets the hitpoints in a bubble around the NPC.
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
		
		return hitPoints;
	}
	
	
	
}
