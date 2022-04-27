package item;

import java.awt.Point;


public class Item {

	private Point location;
	private itemType type; //private variable for holding itemtype
	
	public enum itemType{healthPotion,longsword,shortsword,axe,knife,flashlight,key,map} // enum that holds our types
	
	public Item() {

	}
	
	public Item(int valueForType, Point location) {
		this.type = setTypeByInt(valueForType);
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
	
	//setter for item locaion
	public void setLocation(Point location) {
		this.location = location;
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

}
