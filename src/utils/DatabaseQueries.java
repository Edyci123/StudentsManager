package utils;

import java.sql.*;
import java.util.ArrayList;

public abstract class DatabaseQueries {
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
					+ "(id INTEGER NOT NULL AUTO_INCREMENT, "
					+ "firstName VARCHAR(255), "
					+ "lastName VARCHAR(255), "
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
		
		if (studentAlreadyExtists(s.getFirstName(), s.getLastName(), s.getEmail())) {
			System.out.println("Student already exists!");
			return;
		}
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String query = "INSERT INTO students (firstName, lastName, email) "
					+ String.format("VALUES ('%s', '%s', '%s')", s.getFirstName(), s.getLastName(), s.getEmail());
			
			stmt.execute(query);
			MailUtil.sendRegisterEmail(s.getFirstName(), s.getLastName(), s.getEmail());
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			closeConnections(conn, stmt);
		}	
	}
	
	public static void deleteStudent(String firstName, String lastName) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String query = "DELETE FROM students WHERE "
					+ String.format("firstName = '%s' AND lastName = '%s'", firstName, lastName);
			stmt.execute(query);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			closeConnections(conn, stmt);
		}
	}
	
	public static void updateStudentEmail (String firstName, String lastName, String newEmail) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String query = "UPDATE students "
					+ String.format("SET email = '%s' ", newEmail) 
					+ String.format("WHERE firstName = '%s' AND lastName = '%s'", firstName, lastName);
			stmt.execute(query);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			closeConnections(conn, stmt);
		}
		
	}
	
	public static boolean studentAlreadyExtists(String firstName, String lastName, String email) {
		Connection conn = null;
		Statement stmt = null;
		boolean res = false;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String query = String.format("SELECT 1 FROM students WHERE firstname = '%s' AND lastname = '%s' OR email = '%s'", firstName, lastName, email);    
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				res = true;
			}
			closeConnections(conn, stmt);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			closeConnections(conn, stmt);
		}
		return res;
	}
	
	public static ArrayList<Student> getStudents() {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Student> res = new ArrayList<Student>();
		
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
				res.add(new Student(firstname, lastname, email));
				System.out.println(String.format("%s %s %s %s", id, firstname, lastname, email));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			closeConnections(conn, stmt);
		}
		
		return res;
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