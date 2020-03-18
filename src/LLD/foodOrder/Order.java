package LLD.foodOrder;
import java.util.*;

enum status{
    ACCEPTED,COMPLETED;
}
public class Order {


    Map<Item,Integer> items;
    status orderStatus;

    public Order(Map<Item, Integer> items, status orderStatus) {
        this.items = items;
        this.orderStatus = orderStatus;
    }
}
