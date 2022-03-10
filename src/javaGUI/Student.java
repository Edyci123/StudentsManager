package javaGUI;

public class Student {
	private String firstname;
	private String lastname;
	private String email;
	
	Student(String firstname, String lastname, String email) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail(email);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
