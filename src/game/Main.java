package game;




/*
 * @author Dalton Hodkiewicz, Vivian Gomez
 * */

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		Game game = new Game();
				
		while(!game.isGameOver()) {
			game.determineMove();
			
		}
	}


}
