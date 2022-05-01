package item;

import java.awt.Point;

public class Flashlight extends Item {

	private final String type ="Flashlight";
	
	public Flashlight(int id) {
		super(id);
		this.setDescription("You see a sturdy flashlight, it allows you to see things around you if you say 'light'");
		this.setOz(7.38);
	}

	public Flashlight(Point location, int id) {
		super(location,id);
	}

	public void illuminate() {
		System.out.println("light here");
	}

	public String getType() {
		return type;
	}

}
