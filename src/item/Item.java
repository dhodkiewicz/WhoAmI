* This class represents an item that can be used by the user/player.
 */
package item;

import java.awt.Point;



public class Item {

	private Point location;
	private double weightInOz; // weight in ounces (capacity purposes) // might not even use
	private String description; // description for the items
	private int roomId;

	
	public Item(int id) {
		this.roomId = id;
	}

	public Item(Point location, int id) {
		this.location = location;
		this.roomId = id;
	}

	//getter for item location
	public Point getLocation() {
		return location;
	}

	// Setter for item location
	public void setLocation(Point location)
	{
		this.location = location;
	}


	public double getOz() {
		return weightInOz;
	}

	public void setOz(double oz) {
		this.weightInOz = oz;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	public String getType() throws CloneNotSupportedException {
		return this.clone().toString();
	}
}
