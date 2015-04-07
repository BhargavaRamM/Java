import java.io.*;
import java.util.*;
public class Assignment5 {
	public static void main(String [] args)	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter File Name: ");
		String file = scan.nextLine();
		SongTextFileProcessor writeText = new SongTextFileProcessor(file); 
		
		System.out.println("Menu: a. write a song to the file\t b. read all songs from the file\t c. quit");
		String c = scan.nextLine();
		switch(c)
		{
			case "a":
				
				System.out.println("Song: "); 
				String title = scan.nextLine();
				System.out.println("Artist: "); 
				String artist = scan.nextLine();
				System.out.println("Genre: "); 
				String genre = scan.nextLine();
				
				writeText.writeSong(new Song(title,artist,genre));
				break;
			case "b":
				try {
					Scanner scanner = new Scanner(new File(file));
					while(scanner.hasNext())
					{
						System.out.println(writeText.readSong());						
						scanner.nextLine();
						scanner.nextLine();
						scanner.nextLine();
					}
				}
				catch(IOException e) {
					System.out.println("Error occurred while opening the file.");
				}
				break;
			case "c":
				break;
			default:
				System.out.println("Wrong choice... Enter correctly again..");
				break;
		}
	}
}