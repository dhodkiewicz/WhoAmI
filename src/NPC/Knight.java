/**
 * This class represents a NPC that is a knight.
 */

package NPC;

import java.awt.Point;

public class Knight extends Npc {

	// 1.6 - Proper use of the final keyword.
	//private final String name = "Knight";	// The name of the NPC.
	private double health = 30;				// The knight's starting health.
	
	public Knight(int id) {
		super(id);
		this.setName("Knight");

		// Determine the roomID of the knight and set it's details.
		if (id == 1) {
			this.setAttack(5);
			this.setDescription("A knight stands here with a dagger.");
			this.setMessage(getName() + ": Why do you linger? To get through this room you must get through me.");
			this.setHealth(health - 10);
		}
		if (id == 2) {
			this.setAttack(7.5);
			this.setDescription("A knight stands here with a sword.");
			this.setMessage(getName() + ": I wouldn't if I were you.");
			this.setHealth(health - 5);
		}
		if (id == 3) {
			this.setAttack(10);
			this.setDescription("A knight stands here with a torch.");
			this.setMessage(getName() + ": Are you looking for trouble? Because you're about to find some.");
			this.setHealth(health);
		}
		if (id == 4) {
			this.setAttack(12.5);
			this.setDescription("A knight stands here with a flail.");
			this.setMessage("You've come this far only to lose this battle.");
			this.setHealth(health + 5);
		}
	}

	public Knight(int id, Point location) {
		super(id, location);
	}

	// Gets the name of this type of NPC.
//	public String getName() {
//		return name;
//	}

}
