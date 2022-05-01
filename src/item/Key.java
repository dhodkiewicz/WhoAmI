package item;

import java.awt.Point;

public class Key extends Item {

	private final String type ="Key";
	
	public Key(int id) {
		super(id);
		if(id == 1) {
			this.setDescription("a rusty key");
			this.setOz(2.23);
		}
		if(id == 2) {
			this.setDescription("a silver key");
			this.setOz(3.45);
		}
		if(id == 3) {
			this.setDescription("a golden key");
			this.setOz(1.39);
		}
		if(id == 4) {
			this.setDescription("the Master Key");
			this.setOz(0.45);
		}
	}

	public Key(Point location, int id) {
		super(location,id);
	}

	public String getType() {
		return type;
	}


}
