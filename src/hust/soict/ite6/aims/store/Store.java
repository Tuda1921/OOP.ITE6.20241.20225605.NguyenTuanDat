package hust.soict.ite6.aims.store;

import hust.soict.ite6.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int numberOfDVDs;

    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
        numberOfDVDs = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (numberOfDVDs < itemsInStore.length) {
            itemsInStore[numberOfDVDs] = dvd;
            numberOfDVDs++;
            System.out.println("The DVD has been added to the store.");
        } else {
            System.out.println("The store is full, cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < numberOfDVDs; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < numberOfDVDs - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[numberOfDVDs - 1] = null;  
                numberOfDVDs--;
                found = true;
                System.out.println("The DVD has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD is not found in the store.");
        }
    }

    public void printStore() {
        System.out.println("********** DVDs in the Store **********");
        for (int i = 0; i < numberOfDVDs; i++) {
            System.out.println(itemsInStore[i].toString());
        }
    }
}
