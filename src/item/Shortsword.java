package item;

import java.awt.Point;



public class Shortsword extends Item {

	private final String type ="Shortsword";
	private final double attack = 5;
	
	public Shortsword(int id) {
		super(id);
		if(id == 1) {
			this.setDescription("a battleworn shortsword");
			this.setOz(12.23);
		}
		if(id == 2) {
			this.setDescription("a sturdy, steel shortsword");
			this.setOz(13.45);
		}
		if(id == 3) {
			this.setDescription("a well-crafted elven shortsword");
			this.setOz(11.39);
		}
		if(id == 4) {
			this.setDescription("The Master shortsword");
			this.setOz(7.45);
		}
	}

	public Shortsword(Point location, int id) {
		super(location,id);
	}

	public String getType() {
		return type;
	}
	
	public double getAttack() {
		return attack * this.getRoomId();
	}

}
