package javaGUI;

public class DatabaseQueries {
	private static String username;
	private static String password;
	
	public static void setDatabaseCredentials(String username, String password) {
		DatabaseQueries.setUsername(username);
		DatabaseQueries.setPassword(password);
	}
	
	//TODO methods for communication to the Database

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		DatabaseQueries.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		DatabaseQueries.password = password;
	}

}
