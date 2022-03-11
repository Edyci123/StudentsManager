package javaGUI;

public class firstApp {

	public static void main(String[] args) {
		
		//TODO page with textFields for typing in the username and the password for the database
		//TODO add comments
		//TODO add some kind of a logo
		//TODO add DELETE and UPDATE(just for email) functions
		//TODO add logic that a register has a proper first name and last name(not null, capitalized, not containing any digits), email right form (name@email.com) 
		//TODO add a specific identifier for each student based on his name 
		
		String username = "edyci123";
		String password = "123qwe";
		DatabaseQueries.setDatabaseCredentials(username, password);
		DatabaseQueries.createNewTabel("students");
		
		new RegisterPage();
	}
	
}