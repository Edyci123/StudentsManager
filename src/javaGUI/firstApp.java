package javaGUI;

import java.util.Scanner;

public class firstApp {

	public static void main(String[] args) {
		
		//TODO page with textFields for typing in the username and the password for the database
		@SuppressWarnings("resource")
		Scanner scanner =  new Scanner(System.in);
		
		String username = scanner.nextLine();
		String password = scanner.nextLine();
		DatabaseQueries.setDatabaseCredentials(username, password);
		
		new RegisterPage(username, password);
	}
	
}