/**
 * This class represents a backpack that holds items for the user to use.
 * 			2.3 - Use of Singleton Pattern
 */
package entity;

import java.util.ArrayList;
import java.util.List;

import item.Item;

public class Backpack {

	// 1.5 - Use of the Static keyword
	private List<Item> backpack = null; // List of items in the backpack.

	// Constructor
	private Backpack() {
		// Create the backpack (a list of items).
		backpack = new ArrayList<Item>();
	}

	/**
	 * Creates the single instance of Backpack that will be shared with classes.
	 */
	private static final Backpack instance = new Backpack();

	/**
	 * Gets the instance of Backpack.
	 * @return instance
	 */
	public static Backpack getInstance() {
		return instance;
	}

	/**
	 * This gets the list of items in the backpack.
	 * @return backpack
	 */
	public synchronized List<Item> getBackpack() {
		return this.backpack;
	}

	/**
	 * Add items to the backpack.
	 * @param item
	 */
	public synchronized void addToBackpack(Item item) {
		this.backpack.add(item);
	}

	/**
	 * 1.4a - Use of override of .toString() in at least one scenario.
	 */
	@Override
	public String toString() {

		return backpack.toString();
	}
}