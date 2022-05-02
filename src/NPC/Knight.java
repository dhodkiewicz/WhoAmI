/**
 * This class represents a NPC that is a knight.
 */

package NPC;

import java.awt.Point;

public class Knight extends Npc {

	private final String name = "Knight";	// The name of the NPC.
	
	public Knight(int id) {
		super(id);

		// Determine the roomID of the knight and set it's details.
		if (id == 1) {
			this.setAttack(5);
			this.setDescription("A knight stands here with a dagger.");
			this.setMessage("Why do you linger? To get through this room you must get through me.");
		}
		if (id == 2) {
			this.setAttack(7.5);
			this.setDescription("A knight stands here with a sword.");
			this.setMessage("I wouldn't if I were you.");
		}
		if (id == 3) {
			this.setAttack(10);
			this.setDescription("A knight stands here with a torch.");
			this.setMessage("Are you looking for trouble? Because you're about to find some.");
		}
		if (id == 4) {
			this.setAttack(12.5);
			this.setDescription("A knight stands here with a flail.");
			this.setMessage("You've come this far only to lose this battle.");
		}
	}

	public Knight(int id, Point location) {
		super(id, location);
	}

	// Gets the name of this type of NPC.
	public String getName() {
		return name;
	}
	
	// -------------------------
	//    Create battle here?
	// -------------------------
}
