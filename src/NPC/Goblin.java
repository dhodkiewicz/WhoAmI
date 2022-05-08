/**
 * This class represents a NPC that is a goblin.
 */

package NPC;

import java.awt.Point;

public class Goblin extends Npc {

	private final String name = "Goblin";	// The name of the NPC.
	private double health = 20;				// The goblin's starting health.
	
	// Constructor - accepts a room ID.
	public Goblin(int id) {
		super(id);
		
		// Determine the roomID of the goblin and set it's details.
		if (id == 1) {
			this.setAttack(4);
			this.setDescription("A green goblin stands here.");
			this.setMessage("Be ready for whatever comes at you.");
			this.setHealth(health - 10);
		}
		if (id == 2) {
			this.setAttack(6);
			this.setDescription("A goblin with big ears and fangs stands here.");
			this.setMessage("You have made a mistake stepping on my territory!");
			this.setHealth(health - 5);
		}
		if (id == 3) {
			this.setAttack(8);
			this.setDescription("A goblin with long claws stands here.");
			this.setMessage("No enemy's getting past me!");
			this.setHealth(health);
		}
		if (id == 4) {
			this.setAttack(10);
			this.setDescription("A goblin with a dagger stands here.");
			this.setMessage("You've come this far only to lose this battle.");
			this.setHealth(health + 5);
		}
	}

	// Constructor - accepts room ID and location on an NPC.
	public Goblin(int id, Point location) {
		super(id, location);
	}
	
	// Gets the name of this type of NPC.
	public String getName() {
		return name;
	}

}
