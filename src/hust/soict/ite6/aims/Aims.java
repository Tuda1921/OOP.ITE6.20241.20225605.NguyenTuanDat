package hust.soict.ite6.aims;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.exception.PlayerException;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.Playable;
import hust.soict.ite6.aims.store.Store;
import hust.soict.ite6.aims.media.CompactDisc;
import javafx.scene.control.Alert;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store(10); // Initialize store with capacity of 10
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
    public static void main(String[] args) {
        // Sample Media Items...
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Finding Nemo", "Animation", 15.95f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);

        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCart();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
    private static void viewStore() {
        boolean backToMenu = false;
        while (!backToMenu) {
            store.printStore();
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    backToMenu = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void updateStore() {
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.println("0. Back");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                addMediaToStore();
                break;
            case 2:
                removeMediaFromStore();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void addMediaToStore() {
        System.out.println("Enter media details (title, category, cost): ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        String title = scanner.nextLine();
        String category = scanner.nextLine();
        float cost = scanner.nextFloat();
        DigitalVideoDisc newMedia = new DigitalVideoDisc(title, category, cost);
        store.addMedia(newMedia);
    }

    private static void removeMediaFromStore() {
        System.out.println("Enter media title to remove: ");
        String title = scanner.nextLine();
        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equals(title)) {
                store.removeMedia(media);
                break;
            }
        }
    }

    private static void seeCart() {
        boolean backToMenu = false;
        while (!backToMenu) {
            cart.print();
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    System.out.println("Enter the title of the media to play:");
                    String titleToPlay = scanner.nextLine();
                    Media mediaToPlay = store.getMediaByTitle(titleToPlay);
                    if (mediaToPlay instanceof Playable) {
                        try {
							((Playable) mediaToPlay).play();
						} catch (Exception e) {
							e.printStackTrace();
						}
                    } else {
                        System.out.println("Media not found or cannot be played.");
                    }
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    backToMenu = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void filterCart() {
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice == 1) {
            System.out.println("Enter id to filter: ");
            int id = scanner.nextInt();
            cart.searchById(id);
        } else if (choice == 2) {
            System.out.println("Enter title to filter: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        }
    }

    private static void sortCart() {
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        if (choice == 1) {
            // Sort by title logic
            System.out.println("Sorting by title...");
        } else if (choice == 2) {
            // Sort by cost logic
            System.out.println("Sorting by cost...");
        }
    }

    private static void removeMediaFromCart() {
        System.out.println("Enter media title to remove from cart: ");
        String title = scanner.nextLine();
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().equals(title)) {
                cart.removeMedia(media);
                break;
            }
        }
    }

    private static void playMedia() {
        System.out.println("Enter media title to play: ");
        String title = scanner.nextLine();

        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equals(title)) {
                if (media instanceof CompactDisc) {
                    ((CompactDisc) media).play(); // Call play on CD
                } else if (media instanceof DigitalVideoDisc) {
                    ((DigitalVideoDisc) media).play(); // Call play on DVD
                }
                break;
            }
        }
    }

    private static void addToCart() {
        System.out.println("Enter media title to add to cart: ");
        String title = scanner.nextLine();
        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equals(title)) {
                cart.addMedia(media);
                break;
            }
        }
    }

    private static void placeOrder() {
        System.out.println("Order placed! Cart is now empty.");
        cart = new Cart();  // Clear cart
    }

    private static void seeMediaDetails() {
        System.out.println("Enter media title to view details: ");
        String title = scanner.nextLine();
        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equals(title)) {
                System.out.println("Details: " + media);
                mediaDetailsMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (choice == 1) {
                    cart.addMedia(media);
                    System.out.println("Media added to cart.");
                } else if (choice == 2) {
                    playMedia();
                }
                break;
            }
        }
    }
}
