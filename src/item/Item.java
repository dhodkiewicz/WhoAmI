package item;

import java.awt.Point;

public class Item {

	private Point location;
	private itemType type; //private variable for holding itemtype
	private enum itemType{healthPotion,longsword,shortsword,axe,knife,flashlight,key,map} //private enum that holds our types
	public Item() {
		// TODO Auto-generated constructor stub
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

}
