
import java.util.*;
import java.io.*;
import java.lang.*;

public class Assignment {
	public static void main(String[] args) {
		String song;
		String artist;
		String genre;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter File Name: ");
		String fileName = s.nextLine();
		SongTextFileProcessor writeText = new SongTextFileProcessor(fileName);		
		System.out.println("Menu: a.Read from File\t b.Write to File\t c.quit");
		String c;
		c = s.nextLine();
		switch(c) {
			case "a": 
			try {
				Scanner scan = new Scanner(new File(fileName));
				while(scan.hasNext()) {
					System.out.println(writeText.readSong());
					scan.nextLine();
					scan.nextLine();
					scan.nextLine();
				}
			}
			catch(IOException e){
				System.out.println("There was an error while opening the file.  Exiting...");
			}
			break;
			case "b":
				//try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Song Name: \t");
				song = scanner.nextLine();
				System.out.println("Artist Name: \t");
				artist = scanner.nextLine();
				System.out.println("Genre:\t");
				genre = scanner.nextLine();
				
				writeText.writeSong(new Song(song,artist,genre));
				//} 
				/*
				catch(IOException z) {
					System.out.println("File cannot be found");
				}*/
				break;
			case "c":
				break;
			default :
				System.out.println("Wrong choice... Please enter your choice again...");
		}		
	}
}


class Song  {
	private String song;
	private String artist;
	private String genre;
	public Song(String title,String artistName,String genreName) {
		song = title;
		artist = artistName;
		genre = genreName;
	}
	public void setSong(String title) {
		song = title;
	}
	public String getSong() {
		return song;
	}
	public void setArtist(String artistName) {
		artist = artistName;
	}
	public String getArtist() {
		return artist;
	}
	public void setGenre(String genreName) {
		genre = genreName;
	}
	public String getGenre() {
		return genre;
	}
	public String toString() {
		return String.format("Song Title:"+getSong()+"\tArtist Name: "+getArtist()+"\t Genre: "+getGenre());
	}
}

class SongTextFileProcessor implements SongReader,SongWriter {
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
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName,true)));
			out.write("\n");
			out.write(s.getSong());
			out.write("\n");
			out.write(s.getArtist());
			out.write("\n");
			out.write(s.getGenre());
			out.write("\n");
			out.flush();
			out.close();
		}
		catch(IOException e) {
			System.out.println("Error occurred while opening file");
		}
	}
	public Song [] readAllSongs()
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			ArrayList<Song> songs = new ArrayList<Song>();
			
			Scanner myFile = new Scanner(in);
			String artist = "";
			String genre = "";
			String title = "";
			
			while(myFile.hasNext())
			{
				if(title.equals(""))
				{
					title = myFile.nextLine();
				}
				else if(genre.equals(""))
				{
					genre = myFile.nextLine();
				}
				else if(artist.equals(""))
				{
					artist = myFile.nextLine();
				}
				else
				{
					songs.add(new Song(title, genre, artist));
					artist = ""; genre = ""; title = "";
				}
			}
			if(!(artist.equals("")))
				songs.add(new Song(title, genre, artist));
			myFile.close();
			return songs.toArray(new Song[0]);
		}
		catch(Exception e)
		{
			System.out.println("There was an error while opening the file.");
		}
		return null;
	}
	
	
	public Song readSong(){
		try{
			Scanner scanner = new Scanner(System.in) ;
			return new Song(scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
		}
		catch (Exception x) {
			return null;
		}
	}
	
}

interface SongReader {
	Song readSong();
}


interface SongWriter {
	void writeSong(Song s);
}

	
