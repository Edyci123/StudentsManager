package utils;

//import java.util.regex.Pattern;

public class Student {
	private String firstName;
	private String lastName;
	private String email;
	
	public Student(String firstName, String lastName, String email) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
	}
	
	// checking if the first name, last name and the email are written properly
	public static boolean check (Student s) {
		if (!s.getFirstName().matches("[a-zA-Z]+")) {
			return false;
		} 
		if (!s.getLastName().matches("[a-zA-Z]+")) {
			return false;
		}
		String regex = "^(.+)@(.+)$";
		return s.getEmail().matches(regex);
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
