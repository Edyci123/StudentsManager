package utils;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;

public abstract class DatabaseQueries {
	private static String username;
	private static String password;
	private static final String url = "jdbc:mysql://localhost:3306/firstsql";
	
	public static boolean credentialsValid(String username, String password) { 
		
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static void setDatabaseCredentials(String username, String password) {
		DatabaseQueries.setUsername(username);
		DatabaseQueries.setPassword(password);
	}
	
	public static void createNewTabel(String tableName) { // creating a table for storing the students
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password); // getting a connection to the database
			stmt = conn.createStatement(); // creating a statement
			String sql = "CREATE TABLE students " //creating a query
					+ "(id INTEGER NOT NULL AUTO_INCREMENT, "
					+ "firstName VARCHAR(255), "
					+ "lastName VARCHAR(255), "
					+ "email VARCHAR(255), "
					+ "PRIMARY KEY ( id ))";
			stmt.executeUpdate(sql); //executing the query 
		} catch (SQLException e) {
			System.out.println(e); //printing the error
		} finally {
			closeConnections(conn, stmt); // closing the connections that we don't create too many of them 
		}
		
	}
	
	public static void addNewStudent(Student s) {
		Connection conn = null;
		Statement stmt = null;
		
		if (studentAlreadyExtists(s.getFirstName(), s.getLastName(), s.getEmail())) { //checking the integrity of the answer
			JOptionPane.showMessageDialog(new JFrame(),
					"Student already exists!",
					"Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String query = "INSERT INTO students (firstName, lastName, email) "
					+ String.format("VALUES ('%s', '%s', '%s')", s.getFirstName(), s.getLastName(), s.getEmail());
			
			stmt.execute(query);
			MailUtil.sendRegisterEmail(s.getFirstName(), s.getLastName(), s.getEmail());
			JOptionPane.showMessageDialog(new JFrame(),
					"Succesfully registered!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(),
					e.toString(),
					"Error",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			closeConnections(conn, stmt);
		}	
	}
	
	public static void deleteStudent(String email) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String query = "DELETE FROM students WHERE "
					+ String.format("email = '%s'", email);
			stmt.execute(query);
			JOptionPane.showMessageDialog(new JFrame(),
					"Succesfully deleted!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(),
					e.toString(),
					"Error",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			closeConnections(conn, stmt);
		}
	}
	
	public static void updateStudentEmail (String firstName, String lastName, String oldEmail, String newEmail) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String query = "UPDATE students "
					+ String.format("SET email = '%s' ", newEmail) 
					+ String.format("WHERE firstName = '%s' AND lastName = '%s' AND email = '%s'", firstName, lastName, oldEmail);
			stmt.execute(query);
			JOptionPane.showMessageDialog(new JFrame(),
					"Succesfully updated!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(),
					e.toString(),
					"Error",
					JOptionPane.ERROR_MESSAGE);
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
			String query = String.format("SELECT 1 FROM students WHERE email = '%s'", email);    
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				res = true;
			}
			closeConnections(conn, stmt);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(),
					e.toString(),
					"Error",
					JOptionPane.ERROR_MESSAGE);
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
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				res.add(new Student(firstname, lastname, email));
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
			System.out.println(e);
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