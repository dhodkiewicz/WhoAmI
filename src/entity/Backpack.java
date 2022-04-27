/**
 * This class represents a backpack that holds items for the user to use.
 * 			2.3 - Use of Singleton Pattern
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import item.Item;

public class Backpack
{
	// 1.5 - Use of the Static keyword
	private List<Item> backpack = null;	// List of items in the backpack.
	
	// Constructor
	private Backpack()
	{
		// Create the backpack (a list of items).
		backpack = new ArrayList<Item>();
	}									
	
	
	/**
	 *  Creates the single instance of Backpack that will be shared with classes.
	 */
	private static final Backpack instance = new Backpack();
	
	
	/** 
	 * Gets the instance of Backpack.
	 * @return
	 */
	public static Backpack getInstance() {
		return instance;
	}
	
	
	/**
	 * This gets the list of items in the backpack.
	 * @return backpack
	 */
	public synchronized List<Item> getBackpack()
	{
		return this.backpack;
	}
	
	
	/**
	 * Add items to the backpack.
	 * @param item
	 */
	public synchronized void addToBackpack(Item item)
	{
		this.backpack.add(item);
	}

	
	////////////////////////////////// TEMP - TESTING CODE BELOW ////////////////////////////////////////
	// Probably don't need this since it is already in the Item class.
	/**
	 * This method searches the backpack to see if the item the user is looking for is in the backpack.
	 * 				4.3 - Use of a custom functional interface.
	 * @param itemName
	 * @return item
	 */
	public synchronized Function<String, Item> findItem()
	{
		Function<String, Item> findItem = (iName) -> {
			Item itemToReturn = null;
			
			for(Item item : backpack)
			{
				if(iName.toLowerCase() == item.getType()) {
					return item;
				}
			}
			return itemToReturn;

		};
		
		return null;	// If item is not in the backpack, return null. Handle this where the method is called.
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	// ------------------------------------
	//          COME BACK TO THIS.
	// ------------------------------------
	@Override
	public String toString() {
		
		return backpack.toString();
	}
	
}



/*
 * IGNORE. Random code used for testing.
 * 
	Backpack backpack = Backpack.getInstance();
						
	Item shortSword = new Item("shortsword", "I am a short sword");
	Item axe = new Item("axe", "I am an axe");
					
						
	backpack.addToBackpack(shortSword);
	backpack.addToBackpack(axe);
						
	if (backpack.getBackpack() != null) {
		for(Item i : backpack.getBackpack()) {
			System.out.println(i.getItemDescription());
		}
							
		//System.out.println(backpack.getBackpack());
	}
	else {
		System.out.println("There are no items in the backpack.");
	}
						
	System.out.println(backpack.toString()); 

	System.out.println("Type the name of an item to find in your backpack.");
			
	String itemName = in.nextLine();
			
	if (!itemName.isBlank())
	{
		Item itemFound = backpack.findItem().apply(itemName);
		if(itemFound != null)
		{
			System.out.println("The item you were looking for is in the backpack. What would you like to do with it?");	
		}
		else
		{
			System.out.println("The item you are looking for is not in the backpack. Try looking for a different item.");
		}
				
	}
	else
	{
			System.out.println("Please enter an item name.");
	}
			
 */