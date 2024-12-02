package hust.soict.ite6.aims.media;

public class Disc extends Media{
	private int length;
	private String director;
	
	public Disc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Disc(int length, String director) {
		super();
		this.length = length;
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

}
