package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();

	public Book(List<String> authors) {
		super();
		this.authors = authors;
	}
	private void addAuthor(String authorName) {
		if (authors.contains(authorName) != true)
			authors.add(authorName);
	}
	private void removeAuthor(String authorName) {
		if (authors.contains(authorName) == true)
			authors.remove(authorName);
	}
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	
}
