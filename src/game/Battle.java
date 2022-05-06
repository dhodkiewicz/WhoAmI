/**
 * This functional interface is used to generate a battle.
 */
package game;

import entity.User;

public interface Battle {

	/**
	 * Battle method accepts a user that will be used for battle with NPC.
	 * @param u
	 */
	public abstract void battle(User u) ;
	
	/**
	 * This method is used to check if there's a winner by looking at the user and NPC health.
	 * @param u
	 * @return
	 */
	public abstract boolean checkForWinner(User u);

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
