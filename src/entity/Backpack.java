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

	public static List<Item>backpack = new ArrayList<Item>();
	
	public void addItem(Item i) {
		backpack.add(i);
	}
	
	public List<Item>getBPContents(){
		return backpack;
	}
}



