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
	private enum itemType{healthPotion,longsword,shortsword,axe,knife,flashlight,key,map} //private enum that holds our types
	
	/**
	 * Constructor - Items that will be given to user at the start of a game.
	 * @param type
	 * @param desc
	 */
	public Item(String type , String desc)
	{
		// Set the item type and description.
		setType(type);
		setItemDescription(desc);
	}
	
	/**
	 * Constructor - Used for items that will be scattered in a room for the user to find.
	 * 			1.3 - Use of overloaded method/constructor.
	 * @param type
	 * @param desc
	 * @param itemLocation
	 */
	public Item(String type, String desc, Point itemLocation)
	{
		// Set the item type, description, and location.
		setType(type);
		setItemDescription(desc);
		setLocation(itemLocation);
	}
	
	// Getter for itemType
	public String getType()
	{
		return type.toString();
	}
	
	// Setter for itemType
	public void setType(String type)
	{
		// If the item is found in the enum, set the item type.
		for(itemType item : itemType.values()) {
			if(type == item.toString()) {
				this.type = item;
				break;
			}
		}	
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
	
	
	// -------------------------
	//    COME BACK TO THIS.
	// -------------------------
	@Override
	public String toString()
	{	
		return itemDescription.toString();
	}
}
