import java.util.*;
import java.io.*;

public class Song implements Serializable {
	//private String song;
	private String itemCode;
	private String description;
	private String artist;
	private String album;
	private double price;
	
	public Song(String itemCode,String description,String artist,String album,double price) {
		this.itemCode = itemCode;
		this.description = description;
		this.artist = artist;
		this.album = album;
		this.price = price;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getArtist() {
		return artist;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getAlbum() {
		return album;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public String toString() {
		return String.format(getDescription());
	}
	private void writeObject(ObjectOutputStream out) throws IOException,ClassNotFoundException {
		out.writeUTF(getItemCode());
		out.writeUTF(getDescription());
		out.writeUTF(getArtist());
		out.writeUTF(getAlbum());
		out.writeDouble(getPrice());
	}
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		itemCode = in.readUTF();
		description = in.readUTF();
		artist = in.readUTF();
		album = in.readUTF();
		price = in.readDouble();
	}
}