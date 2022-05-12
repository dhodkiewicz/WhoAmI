/**
 * This interface holds the methods to generate a battle between NPCs and the user.
 */
package game;

import entity.User;

public interface Battle {

	/**
	 * Battle method accepts a user that will be used for battle with NPC.
	 * @param u
	 * @throws InterruptedException 
	 */
	public int battle(User u) throws InterruptedException;
	
	/**
	 * StreetFight method is called when user does not have an equipped weapon.
	 * @param u
	 * @throws InterruptedException 
	 */
	public int streetFight(User u) throws InterruptedException;
	
	/**
	 * This method is used to check if there's a winner by looking at the user and NPC health.
	 * @param u
	 */
	public boolean checkForWinner(double uHealth, double npcHealth);

	/**
	 * This method is called when the user loses a battle.
	 */
	public void lose(User u);

	/**
	 * This method is called when the user wins a battle.
	 */
	public void win();

}
