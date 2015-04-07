package com.assets;
import java.io.*;
import java.util.*;
import java.lang.*;

public class SongTextFileProcessor implements SongReader,SongWriter {
	private String fileName;
	
	
	public SongTextFileProcessor(String file) {
		this.fileName = file;
		try {
			Scanner scanner = new Scanner(new File(fileName));
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void writeSong(Song s) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename,true)));
			out.write(s.getSong());
			out.write(s.getArtist());
			out.write(s.getGenre());
			out.flush();
			out.close();
		}
		catch(IOException e) {
			System.out.println("Error occurred while opening file");
		}
	}
	
	public Song readSong(){
		try{
			return new Song(scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
		}
		catch (IOException x) {
			return null;
		}
	}
	
}