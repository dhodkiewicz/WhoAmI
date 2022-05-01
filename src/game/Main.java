package game;

import java.util.Scanner;



/*
 * @author Dalton Hodkiewicz, Vivian Gomez
 * */

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Game game = new Game();
		
		for(Room r: game.getRooms()) {
			System.out.println("Room id: " + r.getId());
			System.out.println("Room coordinates size:" + r.getRoomCoordinates().size());
			System.out.println("starting Door: " + r.getStartingDoor());
			System.out.println("Ending Door: " +r.getEndingDoor());
			System.out.println("Printing dimensions: " + r.getDimensions());
			System.out.println("Print user current location: " + game.getUser().getLocation());
		}
		
		Scanner in = new Scanner(System.in);
		while(!game.isGameOver()) {
			System.out.println("Please enter a command: " + "\n");
			String s = in.nextLine();
			game.determineMove(s);
			
		}
		in.close();
	}


}
