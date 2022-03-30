package item;

public class Item {

	private itemType type; //private variable for holding itemtype
	private enum itemType{healthPotion,longsword,shortsword,axe,knife,flashlight,key} //private enum that holds our types
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

}
