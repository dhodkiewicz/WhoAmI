/**
 * This class represents a backpack that holds items for the user to use.
 * 			2.3 - Use of Singleton Pattern
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import item.Item;

public class Backpack {

	public static List<Item>backpack = null;
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
