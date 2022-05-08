/**
 * This class represents a NPC that is a pirate.
 */

package NPC;

import java.awt.Point;

public class Pirate extends Npc {

	private final String name = "Pirate";	// The name of the NPC.
	private double health = 25;				// The pirate's starting health.
	
	// Constructor - accepts a room ID.
	public Pirate(int id) {
		super(id);
		
		// Determine the roomID of the pirate and set it's details.
		if (id == 1) {
			this.setAttack(5);
			this.setDescription("A pirate with a small sword stands here.");
			this.setMessage("I wouldn't be here if I were you.");
			this.setHealth(health - 10);
		}
		if (id == 2) {
			this.setAttack(10);
			this.setDescription("A pirate with a hook stands here.");
			this.setMessage("You have made a mistake stepping on my territory!");
			this.setHealth(health - 5);
		}
		if (id == 3) {
			this.setAttack(6.5);
			this.setDescription("A pirate with a dagger stands here.");
			this.setMessage("Are you looking for trouble? Because you're about to find some.");
			this.setHealth(health);
		}
		if (id == 4) {
			this.setAttack(8);
			this.setDescription("A pirate with an axe stands here.");
			this.setMessage("You've come this far only to lose this battle.");
			this.setHealth(health + 5);
		}
	}

	// Constructor - accepts a room ID and a location for the NPC.
	public Pirate(int id, Point location) {
		super(id, location);
	}

	// Gets the name of this type of NPC.
	public String getName() {
		return name;
	}

}
