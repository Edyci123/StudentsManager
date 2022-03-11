package javaGUI;

public class firstApp {

	public static void main(String[] args) {
		
		//TODO page with textFields for typing in the username and the password for the database
		//TODO add comments
//		@SuppressWarnings("resource")
//		Scanner scanner =  new Scanner(System.in);
//		
//		String username = scanner.nextLine();
//		String password = scanner.nextLine();
		
		String username = "edyci123";
		String password = "123qwe";
		DatabaseQueries.setDatabaseCredentials(username, password);
		//DatabaseQueries.createNewTabel("students");
		
		new RegisterPage(username, password);
	}
	
}