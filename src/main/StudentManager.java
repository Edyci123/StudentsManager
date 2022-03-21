package main;

import pages.InsertCredentials;
import utils.Music;

public class StudentManager {

	public static void main(String[] args) {
		
		// in order for this app to work you will have to have a database entitled firstSQL
		Music.setMusic(); // initialize the array of songs to sent to new registered students
		new InsertCredentials(); // initialize the first page in which you should introduce the credentials of the database
	}
	
}