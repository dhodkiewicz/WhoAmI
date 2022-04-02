package game;

import java.awt.Point;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Game game = new Game();
		Room room = new Room(); // rooms will automatically be constructed in game constructor but this was just for testing purposes
		System.out.println(room.getDimensions());
		for(Point point : room.getRoomCoordinates()) {
			System.out.println(point); // room coordinates populating and instantiating correctly :) Next need to define amount of Rooms upon instantiation and logic
		}                             // behind linking them together
		
		room.setDoors();
		System.out.println(room.getRoomCoordinates().size());
		System.out.println(room.getStartingDoor()); // arbitrary way of setting door locations for now- will work on logic later
		System.out.println(room.getEndingDoor());
		

	}

}
