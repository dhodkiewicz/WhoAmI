package item;

import java.awt.Point;

public class HealthPotion extends Item {

	private int healthPoints = 100;
	private final String type ="Health Potion";
	
	public HealthPotion(int id) {
		super(id);
	}

	public HealthPotion(Point location, int id) {
		super(location,id);
	}
		
	

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public String getType() {
		return type;
	}

}
