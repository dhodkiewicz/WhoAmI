package item;

import java.awt.Point;




public class Longsword extends Item {

	private final double attack = 7.5;
	private final String type ="Longsword";

	
	public Longsword(int id) {
		super(id);
		if(id == 1) {
			this.setDescription("a battleworn longsword");
			this.setOz(12.23);
		}
		if(id == 2) {
			this.setDescription("a sturdy, steel longsword");
			this.setOz(13.45);
		}
		if(id == 3) {
			this.setDescription("a well-crafted elven longsword");
			this.setOz(11.39);
		}
		if(id == 4) {
			this.setDescription("The Master longsword");
			this.setOz(7.45);
		}
	}

	public Longsword(Point location, int id) {
		super(location,id);
	}

	public double getAttack() {
		return attack * this.getRoomId();
	}


	public String getType() {
		return type;
	}

}
