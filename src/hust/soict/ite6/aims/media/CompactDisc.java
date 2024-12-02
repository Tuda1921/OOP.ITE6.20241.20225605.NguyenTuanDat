package hust.soict.ite6.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks;
	public CompactDisc(int length, String director, String artist, ArrayList<Track> tracks) {
		super(length, director);
		this.artist = artist;
		this.tracks = tracks;
	}
	public String getArtist() {
		return artist;
	}

	private void addTrack(Track trackName) {
		if (tracks.contains(trackName) != true)
			tracks.add(trackName);
	}
	private void removeTrack(String trackName) {
		if (tracks.contains(trackName) == true)
			tracks.remove(trackName);
	}
	
	public int getLength() {
		int sum = 0;
		for (Track i : tracks) {
			sum += i.getLength();
		}
		return sum;
	}
	public void play() {
	    System.out.println("Playing CD: " + this.getTitle());
	    System.out.println("Artist: " + this.getArtist());
	    System.out.println("CD length: " + this.getLength());
	    
	    for (Track track : tracks) {
	        track.play();
	    }
	}
}
