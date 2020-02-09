package LLD.AmazonShoppingCart.shoppingcart;

import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    public boolean addItem(Item item){return true;}
    public boolean removeItem(Item item){return true;}
    public boolean updateItemQuantity(Item item, long quantity){return true;}
    public List<Item> getItems(){return items;}
    public boolean checkout(){return true;}
}
