public class Song {
	private String song;
	private String genre;
	private String artist;
	public Song(String songName, String artistName, String genreName) {
		song = songName;
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
	public String getSongInfo() {
		return song + "\n" + artist + "\n" +genre;
	}
	public String toString() {
		return  "\tSong: " + song+"Artist: " + artist+ "\tGenre: " +genre;
	}
}