/**
 * This class represents an item that can be used by the user/player.
 */
package item;

import java.awt.Point;

public class Item
{	
	private Point location;			// The location of the item.
	private itemType type; 			// Private variable for holding itemType
	private String itemDescription; // Describes the item.
	public enum itemType{healthPotion,longsword,shortsword,axe,knife,flashlight,key,map} //private enum that holds our types
	
	public Item() {
		
	}
	
	/**
	 * Constructor - Items that will be given to user at the start of a game.
	 * @param type
	 * @param desc
	 */
	public Item(itemType type , String desc)
	{
		// Set the item type and description.
		setType(type);
		setItemDescription(desc);
	}
	
	/**
	 * Constructor - Used for items that will be scattered in a room for the user to find.
	 * 			1.3 - Use of overloaded method/constructor.
	 * @param type
	 * @param location
	 */
	public Item(itemType type, Point location) {
		this.type = type;
		this.location = location;
	}
	
	// Getter for itemType
	public itemType getType()
	{
		return type;
	}
	
	// Setter for itemType
	public void setType(itemType type)
	{
		this.type = type;
	}
	
	// Getter for item location
	public Point getLocation()
	{
		return location;
	}
	
	// Setter for item location
	public void setLocation(Point location)
	{
		this.location = location;
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
	
	//return all item types
	public static itemType[] getAllItemTypes() {
		return itemType.values();
	}
	
	
	//method to help easily set item types
	public itemType setTypeByInt(int value) {
		itemType type = null;

		if(value == 0) {
			type = itemType.key;
		}
		if(value == 1) {
			type = itemType.flashlight;
		}
		if(value == 2) {
			type = itemType.map;
		}
		if(value == 3) {
			type = itemType.healthPotion;
		}
		if(value == 4) {
			type = itemType.longsword;
		}
		if(value == 5) {
			type = itemType.shortsword;
		}
		if(value == 6) {
			type = itemType.axe;
		}
		if(value == 7) {
			type = itemType.knife;
		}

		return type;

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
