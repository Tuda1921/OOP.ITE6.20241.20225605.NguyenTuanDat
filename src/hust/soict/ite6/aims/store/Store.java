package hust.soict.ite6.aims.store;

import hust.soict.ite6.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore;
    private int numberOfItems; 

    // Constructor
    public Store(int capacity) {
        itemsInStore = new ArrayList<>(capacity);
        numberOfItems = 0;
    }

    public void addMedia(Media media) {
        if (numberOfItems < itemsInStore.size()) {
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
}
