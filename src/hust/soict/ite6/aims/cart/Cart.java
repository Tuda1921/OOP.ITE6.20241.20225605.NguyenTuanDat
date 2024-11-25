package hust.soict.ite6.aims.cart;

import hust.soict.ite6.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public Cart() {}
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(this.qtyOrdered < MAX_NUMBERS_ORDERED){
            this.itemsOrdered[this.qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else System.out.println("The cart is almost full");
    }
//    public void addDigitalVideoDisc(DigitalVideoDisc disc[]) {
//    	for (DigitalVideoDisc dvd : dvds) {
//            addDigitalVideoDisc(dvd);
//        }
//    }
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            addDigitalVideoDisc(dvd);
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
    	addDigitalVideoDisc(dvd1);
    	addDigitalVideoDisc(dvd2);
    }   
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed");
                return;
            }
        }
    }
    public float totalCost(){
        float total = 0;
        for(int i=0;i<qtyOrdered;i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    public int getqtyOrdered(){
        return qtyOrdered;
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
        	DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.println((i + 1) + ". " + dvd);
            totalCost += dvd.getCost();
        }
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }
    public DigitalVideoDisc searchById(int id) {
    	for (int i = 0; i < qtyOrdered; i++)  {
        	if (itemsOrdered[i].getId() == id) {
                System.out.println("Found with ID " + id + ": " + itemsOrdered[i]);
                return itemsOrdered[i];
            }
        }
        System.out.println("No DVD found with ID " + id);
        return null;
    }
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
        	if (itemsOrdered[i].isMatch(title)) {
                System.out.println(itemsOrdered[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title \"" + title + "\"");
        }
    }
}
