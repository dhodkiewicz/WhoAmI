package game;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.Scanner;

/*
 * @author Dalton Hodkiewicz, Vivian Gomez, Kyler Lambert
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

		while(!game.isGameOver()) {
			System.out.println("Please enter a command: " + "\n");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();
			game.determineMove(s);
		}
	}

}
