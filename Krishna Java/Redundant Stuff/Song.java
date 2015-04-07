//package com.assets;
//import java.util.*;
//import java.lang.*;

public class Song  {
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
		return String.format("Song Title:"+getSong()+"/tArtist Name: "+getArtist()+"/t Genre: "+getGenre());
	}
}


