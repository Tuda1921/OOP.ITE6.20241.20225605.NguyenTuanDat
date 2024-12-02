package hust.soict.ite6.aims;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args){
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // In tổng chi phí của các DVD trong giỏ hàng
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        int before_remove = anOrder.getqtyOrdered();
        anOrder.removeDigitalVideoDisc(dvd3);
        int after_remove = anOrder.getqtyOrdered();
        if(before_remove > after_remove){
            System.out.println("Remove success");
        } else{
            System.out.println("Remove fail");
        }

    }
}
