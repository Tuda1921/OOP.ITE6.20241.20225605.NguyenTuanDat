package hust.soict.ite6.aims.cart;

import java.util.ArrayList;

import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart extends Media{
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public Cart() {}
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED && media != null) {
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
        } else {
            System.out.println("The cart is full. Cannot add more items.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Media not found in the cart.");
        }
    }
    
    public float totalCost(){
        float total = 0;
        for(int i=0;i<itemsOrdered.size();i++){
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }
    
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + dvd);
            totalCost += dvd.getCost();
        }
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }

    public DigitalVideoDisc searchById(int id) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println("Found with ID " + id + ": " + itemsOrdered.get(i));
                return (DigitalVideoDisc) itemsOrdered.get(i);
            }
        }
        System.out.println("No DVD found with ID " + id);
        return null;
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            if (media instanceof DigitalVideoDisc && ((DigitalVideoDisc) media).isMatch(title)) {
                System.out.println(media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title \"" + title + "\"");
        }
    }
	public ObservableList<Media> getItemsOrdered() {
        return FXCollections.observableArrayList(itemsOrdered);
    }

	public String placeOrder() {
        if (itemsOrdered.isEmpty()) {
            return "Your cart is empty!";
        } else {
            itemsOrdered.clear();
            return "Order created!\n" + "Now your cart will be empty!";
        }
    }

}
