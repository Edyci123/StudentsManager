package javaGUI;

import java.sql.*;

public class DatabaseQueries {
	private static String username;
	private static String password;
	private static final String url = "jdbc:mysql://localhost:3306/firstsql";
	
	public static void setDatabaseCredentials(String username, String password) {
		DatabaseQueries.setUsername(username);
		DatabaseQueries.setPassword(password);
	}
	
	public static void createNewTabel(String tableName) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String sql = "CREATE TABLE students " 
					+ "(id INTEGER NOT	 NULL AUTO_INCREMENT, "
					+ "firstname VARCHAR(255), "
					+ "lastname VARCHAR(255), "
					+ "email VARCHAR(255), "
					+ "PRIMARY KEY ( id ))";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			closeConnections(conn, stmt);
		}
		
	}
	
	public static void addNewStudent(Student s) {
		Connection conn = null;
		Statement stmt = null;
		
		if (studentAlreadyExtists(s.getFirstname(), s.getLastname())) {
			System.out.println("Student already exists!");
			return;
		}
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String query = "INSERT INTO students (firstname, lastname, email) "
					+ String.format("VALUES ('%s', '%s', '%s')", s.getFirstname(), s.getLastname(), s.getEmail());
			
			stmt.execute(query);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			closeConnections(conn, stmt);
		}	
	}
	
	public static boolean studentAlreadyExtists(String firstname, String lastname) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String query = String.format("SELECT 1 FROM students WHERE firstname = '%s' AND lastname = '%s'", firstname, lastname);    
			boolean res = stmt.execute(query);
;			closeConnections(conn, stmt);
			return res;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			closeConnections(conn, stmt);
		}
		return false;
	}
	
	public static void showStudents() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			
			String query = "SELECT * FROM students";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				System.out.println(String.format("%s %s %s %s", id, firstname, lastname, email));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			closeConnections(conn, stmt);
		}
		
	}
	
	private static void closeConnections(Connection conn, Statement stmt) {
		try {
			if (stmt != null) { stmt.close(); }
			if (conn != null) { conn.close(); }
		} catch (SQLException e) {
			System.out.println("aici" + e);
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
