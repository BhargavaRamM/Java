import java.io.*;
import java.util.*;
import java.lang.*;
public class SongBinaryFileProcessor implements SongReader,SongWriter {
	private String fileName;
	private DataInputStream data;
	
	public SongBinaryFileProcessor(String file) {
		this.fileName = file;
		try {
			data = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName))); 
		}
		catch(IOException e) {
			System.out.println("Exception thrown..");
		}
	}
	public void writeSong(Song s) {
		try {
			DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName,true)));
			out.writeUTF(s.getSong());
			out.writeUTF(s.getArtist());
			out.writeUTF(s.getGenre());
			out.flush();
			out.close();
		}
		catch(IOException e) {
			System.out.println("Error occurred while opening file");
		}
	}
	
	public Song readSong(){
		try{
			return new Song(data.readUTF(),data.readUTF(),data.readUTF());
		}
		catch (IOException x) {
			return null;
		}
	}
}