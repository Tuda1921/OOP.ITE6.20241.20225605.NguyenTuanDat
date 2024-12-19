package hust.soict.ite6.aims.store;

import hust.soict.ite6.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore;
    private int numberOfItems; 
    public Store() {
        this.itemsInStore = new ArrayList<>(); // Khởi tạo danh sách
        this.numberOfItems = 0;
    }
    // Constructor
    public Store(int capacity) {
        itemsInStore = new ArrayList<>(capacity);
        numberOfItems = 0;
    }

    public void addMedia(Media media) {
        if (media != null) {
            itemsInStore.add(media);
            numberOfItems++;
            System.out.println("The media has been added to the store.");
        } else {
            System.out.println("The store is full, cannot add more items.");
        }
    }
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            numberOfItems--;
            System.out.println("The media has been removed from the store.");
        } else {
            System.out.println("The media is not found in the store.");
        }
    }

    public void printStore() {
        System.out.println("********** Items in the Store **********");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }
    public Media getMediaByTitle(String titleToPlay) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(titleToPlay)) {
                return media; // Return the media with the matching title
            }
        }
        return null; // Return null if no matching media found
    }
}
