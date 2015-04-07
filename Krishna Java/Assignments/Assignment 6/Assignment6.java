import java.util.*;
import java.io.*;
import java.lang.*;
public class Assignment6 {
	public static void main(String[] args) {
		String fileName;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter File Name: ");
		fileName = scan.nextLine();
		SongBinaryFileProcessor writeText = new SongBinaryFileProcessor(fileName);
		System.out.println("Menu: a.Write Song to file\t b.Read songs from file\t c.quit");
		String c = scan.nextLine();
		switch(c) {
			case "a":
			System.out.println("Song:");
			String song = scan.nextLine();
			String artist = scan.nextLine();
			String genre = scan.nextLine();
			writeText.writeSong(new Song(song,artist,genre));
			break;
			
			case "b":
			try {
				DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
				while(in.readUTF() != null) {
					System.out.println(writeText.readSong());
					in.readUTF();
					in.readUTF();
				}
			}
			catch(IOException e) {
				//System.out.println("Exception thrown");
			}
			break;
			case "c":
			break;
			default:
			System.out.println("Wrong Choice..Choose a valid choice");
		}
	}
}