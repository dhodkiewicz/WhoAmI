package game;

import java.util.Scanner;

import item.Item;




/*
 * @author Dalton Hodkiewicz, Vivian Gomez
 * */

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Game game = new Game();
		
		for(Room r: game.getRooms()) {
			System.out.println("Room id: " + r.getId());
			System.out.println("Room coordinates size:" + r.getRoomCoordinates().size());
			System.out.println("starting Door: " + r.getStartingDoor()); // arbitrary way of setting door locations for now- will work on logic later
			System.out.println("Ending Door: " +r.getEndingDoor());
			System.out.println("Printing dimensions: " + r.getDimensions());
			System.out.println("Print user current location: " + game.getUser().getLocation());
			/*
			 * for(Point point : r.getRoomCoordinates()) { System.out.println(point); //
			 * room coordinates populating and instantiating correctly :) Next need to
			 * define amount of Rooms upon instantiation and logic }
			 */
		}
		Scanner in = new Scanner(System.in);
		while(!game.isGameOver()) {
			System.out.println("Please enter a command: " + "\n");
			String s = in.nextLine();
			game.determineMove(s);
			
			Item i = game.isUserNearItem();
			if (isUserNearItem(i)) {
				//TODO ask player if they would like to pick up the item and infer logic
				System.out.println("User is near a " + i.getType() + " would you like to pick it up?");
			}
			
		}
		in.close();
	}

	public static boolean isUserNearItem(Item i){
		if(i == null)
		return false;
		else {
			return true;
		}
		
	}
}
