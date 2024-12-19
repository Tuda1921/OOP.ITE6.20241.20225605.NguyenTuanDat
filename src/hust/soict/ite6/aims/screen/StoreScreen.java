package hust.soict.ite6.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.Track;
import hust.soict.ite6.aims.store.Store;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }
        return center;
    }

    public StoreScreen(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args) {
        Store S = new Store();
        Cart C = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Memento", "Thriller", "Christopher Nolan", 113, 24.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 19.99f);
        S.addMedia(dvd1);
        S.addMedia(dvd2);

        Book book1 = new Book(1, "War and Peace", "Historical", 12.99f);
        book1.addAuthor("Leo Tolstoy");
        Book book2 = new Book(2, "Pride and Prejudice", "Romance", 9.99f);
        book2.addAuthor("Jane Austen");
        Book book3 = new Book(3, "Brave New World", "Dystopian", 14.99f);
        book3.addAuthor("Aldous Huxley");
        book3.addAuthor("Another Contributor");
        S.addMedia(book1);
        S.addMedia(book2);
        S.addMedia(book3);

        ArrayList<Track> tracks1 = new ArrayList<>();
        tracks1.add(new Track("Opening Theme", 3));
        tracks1.add(new Track("End Credits", 5));

        ArrayList<Track> tracks2 = new ArrayList<>();
        tracks2.add(new Track("Track Alpha", 7));
        tracks2.add(new Track("Track Beta", 4));
        tracks2.add(new Track("Track Gamma", 6));

        ArrayList<Track> tracks3 = new ArrayList<>();
        tracks3.add(new Track("Song 1", 2));
        tracks3.add(new Track("Song 2", 5));

        ArrayList<Track> tracks4 = new ArrayList<>();
        tracks4.add(new Track("Melody A", 4));
        tracks4.add(new Track("Melody B", 3));
        tracks4.add(new Track("Melody C", 6));

        CompactDisc cd1 = new CompactDisc(1, "Pop Hits", "Pop", 14.99f, 11, "Director X", "Artist X");
        cd1.addTrack(new Track("Intro", 2));
        cd1.addTrack(new Track("Outro", 3));

        CompactDisc cd2 = new CompactDisc("Director Y", "Artist Y", tracks1);

        CompactDisc cd3 = new CompactDisc("Artist Z", tracks2);

        CompactDisc cd4 = new CompactDisc(45, "Director W", "Artist W", tracks4);
        S.addMedia(cd1);
        S.addMedia(cd2);
        S.addMedia(cd3);
        S.addMedia(cd4);


        new StoreScreen(S, C);
    }
}