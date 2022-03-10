package javaGUI;

import java.sql.*;

public class DatabaseQueries {
	private static String username;
	private static String password;
	private static final String url = "jdbc:mysql://localhost:3306/students";
	
	public static void setDatabaseCredentials(String username, String password) {
		DatabaseQueries.setUsername(username);
		DatabaseQueries.setPassword(password);
	}
	
	//TODO methods for communication to the Database
	
	public static void createNewTabel(String tableName) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String query = "CREATE TABLE students (firstname VARCHAR(64), lastname VARCHAR(64), email VARCHAR(64))";
			stmt.execute(query);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (stmt != null) { stmt.close(); }
			} catch (SQLException e) {
				System.out.println(e);
			}
			
			try {
				if (conn != null) { conn.close(); }
			} catch (SQLException e) {
				System.out.println(e);
			}	
		}
		
	}
	
	public static void addNewStudent(Student s) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String query = "INSERT INTO students "
					+ "(firstname, lastname, email) "
					+ "VALUES (" + s.getFirstname() + ", " + s.getLastname() + ", " + s.getEmail() + ");";
			
			stmt.execute(query);
			
		} catch (SQLException e) {
			System.out.println("Could not connect to DB: " + e);
		} finally {
			try {
				if (stmt != null) { stmt.close(); }
			} catch (SQLException e) {
				System.out.println(e);
			}
			
			try {
				if (conn != null) { conn.close(); }
			} catch (SQLException e) {
				System.out.println(e);
			}	
		}	
	}

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

	public static String getUrl() {
		return url;
	}

}
