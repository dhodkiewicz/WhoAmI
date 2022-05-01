package item;

import java.awt.Point;



public class Axe extends Item {
	

	private final double attack = 10;
	private final String type ="Axe";
	
	public Axe(int id) {
		super(id);
		if(id == 1) {
			this.setDescription("a battleworn axe");
			this.setOz(12.23);
		}
		if(id == 2) {
			this.setDescription("a sturdy, steel axe");
			this.setOz(13.45);
		}
		if(id == 3) {
			this.setDescription("a well-crafted elven axe");
			this.setOz(11.39);
		}
		if(id == 4) {
			this.setDescription("The Master Axe");
			this.setOz(7.45);
		}
	}

	public Axe(Point location, int id) {
		super(location,id);
	}

	public String getType() {
		return type;
	}

	public double getAttack() {
		return attack * this.getRoomId();
	}

}
