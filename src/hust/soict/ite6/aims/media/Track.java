package hust.soict.ite6.aims.media;

import hust.soict.ite6.aims.exception.PlayerException;

import java.util.Objects;

public class Track implements Playable {
	private String title;
	private int length;

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Track other = (Track) obj;
        return Objects.equals(title, other.title) && length == other.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length);
    }

	public void play() { 
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}

    public String playGUI() throws PlayerException {
        if (this.getLength() > 0) {
            return "Playing track: " + this.getTitle() + "\n" +
                "Track length: " + this.getLength();
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }


    }
}
