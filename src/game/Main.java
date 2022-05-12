package game;




/*
 * @author Dalton Hodkiewicz, Vivian Gomez
 * */

public class Main {
	public static void main(String[] args) throws Exception {
		Game game = new Game();
				
		while(!game.isGameOver()) {
			game.determineMove();
			
		}
	}
}
