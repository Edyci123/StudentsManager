package utils;

import java.util.regex.Pattern;

public class Student {
	private String firstName;
	private String lastName;
	private String email;
	
	public Student(String firstName, String lastName, String email) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
	}
	
	public static boolean check (Student s) {
		if (Pattern.matches("[0-9]+", s.getFirstName()) == true) {
			return false;
		} 
		if (Pattern.matches("[0-9]+", s.getLastName()) == true) {
			return false;
		}
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		return (boolean)pattern.matcher(s.getEmail()).matches();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
