package game;


public interface Command {

	public void use(String str);

	
	public void determineMove() throws CloneNotSupportedException, Exception;
	
	   // static method
    static void hello()
    {
        System.out.println("Welcome to WhoAmI!\n \n"
        		+ "Default commands are: \n \n"
        		+ " move south,\n move north,\n move east,\n move west,"
        		+ "\n and use \n");
    }
    
    


}
