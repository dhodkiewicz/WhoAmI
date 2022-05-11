package game;

// 1.8 - Use of Enumerations
public enum ValidCommands {
	MOVE_NORTH("move north"),
	MOVE_SOUTH("move south"),
	MOVE_EAST("move east"),
	MOVE_WEST("move west"),
	USE("use"),
	END_GAME("end game");
	
	private String command;

	ValidCommands(String string) {
		this.command = string;
	}
	
	public String getCommand() {
		return this.command;
	}
}
