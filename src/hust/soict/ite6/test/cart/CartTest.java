package hust.soict.ite6.test.cart;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Ron Clements", 90, 18.99f);
        cart.addMedia(dvd3);
        cart.print();
        cart.searchById(1);
        cart.searchByTitle("Aladin");
    }
}
