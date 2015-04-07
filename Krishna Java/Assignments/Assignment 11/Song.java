import java.util.*;
public class Song {
	private String recordingArtist;
	private double price;
    private String songTitle;
	
	public Song(String recordingArtist, double price, String songTitle) {
		this.recordingArtist = recordingArtist;
		this.price = price;
        this.songTitle = songTitle;
	}
		public void setRecordingArtist(String recordingArtist) {
		this.recordingArtist = recordingArtist;
	}
	public String getRecordingArtist() {
		return recordingArtist;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
    public double getPrice() {
		return price;
	}  
    public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public String getSongTitle() {
		return songTitle;
	}
	public String toString() {
		return "Song Title: " + songTitle + "\nArtist: " + recordingArtist + "\nPrice: $"
				+ String.format("%.2f" ,price) + "\n";
	}
	
}