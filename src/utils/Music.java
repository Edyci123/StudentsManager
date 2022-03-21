package utils;

import java.io.*;
import java.util.ArrayList;

public class Music {
	public static ArrayList<String> music = new ArrayList<String>();
	
	public static void setMusic() {
		try {
			// parsing a file so extract the music tracks
			File file = new File("MusicFile/Music.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;

			while ((line = br.readLine()) != null) {
				music.add(line);
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static String getRandMusicLink() {
		int index = (int)(Math.random() * music.size());
		
		return music.get(index);
	}
	
	
}
