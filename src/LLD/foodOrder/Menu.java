package LLD.foodOrder;

import java.util.*;

public class Menu {
    Map<Item,Integer> items = new HashMap<>();

    void addItem(Item item, int quantity){
        items.put(item,items.getOrDefault(item,0)+1);
    }
}
