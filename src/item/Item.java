/**
 * This class represents an item that can be used by the user/player.
 */
package item;

import java.awt.Point;


public class Item {

	private Point location;
	private itemType type; //private variable for holding itemtype

	public enum itemType{healthPotion,longsword,shortsword,axe,knife,flashlight,key,map} // enum that holds our types

	public Item() {

	}

	public Item(itemType type, Point location) {
		this.type = type;
		this.location = location;
	}

	//getter for itemtype
	public itemType getType() {
		return type;
	}

	//setter for itemtype
	public void setType(itemType type) {
		this.type = type;
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

	//return all item types
	public static itemType[] getAllItemTypes() {
		return itemType.values();
	}


	// Getter for item description.
	public String getItemDescription()
	{
		return itemDescription;
	}

	// Setter for item description.
	public void setItemDescription(String itemDesc)
	{
		this.itemDescription = itemDesc;
	}


	// -------------------------
	//    COME BACK TO THIS.
	// -------------------------
	@Override
	public String toString()
	{
		return itemDescription.toString();
	}
}
