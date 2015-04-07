import java.util.*;
import java.io.*;
import java.awt.*;

public class SongDatabase {
	public static Song[] readSongs() {
	ArrayList<Song> songsList = new ArrayList<Song>();
	Song [] songs = {new Song("...","...","...","...",0.00)};
	ObjectInputStream in = null;
	try {
		in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("SongsFile.dat")));
		songsList = (ArrayList<Song>) in.readObject();
		in.close();
		if(songsList.size() != 0) {
			songs = new Song[songsList.size()];
			for(int i = 0; i < songs.length; i++) {
				songs[i] = songsList.get(i);
			}
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return songs;	
	}
	
	public static void writeSong(Song addedSong)  {
        ArrayList<Song> newSongsList = new ArrayList<Song>();
        Song [] newSongArray = SongDatabase.readSongs();
        for(Song s : newSongArray) {
			newSongsList.add(s);
        }
        newSongsList.add(addedSong);
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("SongsFile.dat")));
            out.writeObject(newSongsList);
            out.flush();
            out.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
     
    public static void editSong(int index, Song editedSong) {
        ArrayList<Song> newSongsList = new ArrayList<Song>();
        Song [] newSongArray = SongDatabase.readSongs();
        for(Song s : newSongArray) {
            newSongsList.add(s);
        }
        newSongsList.set(index,editedSong);
        ObjectOutputStream out = null;
        try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("SongsFile.dat")));
            out.writeObject(newSongsList);
            out.flush();
            out.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
     }
	
	public static void deleteSong(int index) {
        ArrayList<Song> newSongsList = new ArrayList<Song>();
        Song [] newSongArray = SongDatabase.readSongs();
        for(Song s : newSongArray) {
            newSongsList.add(s);
        }
        newSongsList.remove(index);
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("SongsFile.dat")));
            out.writeObject(newSongsList);
            out.flush();
            out.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

  
