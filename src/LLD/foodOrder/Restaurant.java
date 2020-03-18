package LLD.foodOrder;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
    Menu menu;
    int rating;

    public Restaurant(Menu menu, int rating) {
        this.menu = menu;
        this.rating = rating;
    }

    static final int max_Size = 5;
    Queue<Order> processing = new LinkedList<Order>();

    public Restaurant(Menu menu, int rating, Queue<Order> processing) {
        this.menu = menu;
        this.rating = rating;
        this.processing = processing;
    }

    void updateMenu(Item item){
        menu.addItem(item,1);
    }

    void placeOrder(Order order){
        processing.add(order);
    }


    public boolean canProcess() {
        if(processing.size()<max_Size){
            return true;
        }
        return false;
    }
}
