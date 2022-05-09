/**
 * This interface holds the methods to generate a battle between NPCs and the user.
 * Note to self: all methods in an interface are public and abstract.
 */
package game;

import entity.User;

public interface Battle {

	/**
	 * Battle method accepts a user that will be used for battle with NPC.
	 * @param u
	 */
	public int battle(User u);
	
	/**
	 * StreetFight method is called when user does not have an equipped weapon.
	 * @param u
	 * @return
	 */
	public int streetFight(User u);
	
	/**
	 * This method is used to check if there's a winner by looking at the user and NPC health.
	 * @param u
	 */
	public boolean checkForWinner(double uHealth, double npcHealth);

	/**
	 * This method is called when the user loses a battle.
	 * TODO - This method is unfinished.
	 */
	public void lose();

	/**
	 * This method is called when the user wins a battle.
	 */
	public void win();

}
