package LLD.AmazonShoppingCart.inventory;

import LLD.AmazonShoppingCart.actors.Account;

public class Product {
    private String productID;
    private String name;
    private String description;
    private double price;
    private ProductCategory category;
    private long availableItemCount;

    private Account seller;

    public long getAvailableCount(){
        return 1;
    }
    public boolean updatePrice(double newPrice){
        return true;
    }
}
