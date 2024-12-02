package hust.soict.ite6.test.media;

import java.util.ArrayList;
import java.util.List;

class Media {
    private String title;

    public Media(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Media: " + title;
    }
}

class CD extends Media {
    public CD(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "CD: " + getTitle();
    }
}

class DVD extends Media {
    public DVD(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "DVD: " + getTitle();
    }
}

class Book extends Media {
    public Book(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Book: " + getTitle();
    }
}

public class mediatest {

    public mediatest() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<>();

        CD cd = new CD("Rock Album");
        DVD dvd = new DVD("Movie XYZ");
        Book book = new Book("Java Programming");

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
