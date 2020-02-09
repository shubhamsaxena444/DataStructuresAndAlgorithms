package LLD.AmazonShoppingCart.search;

import LLD.AmazonShoppingCart.inventory.Product;
import java.util.List;

public interface Search {
    public List<Product> searchProductsByName(String name);
    public List<Product> searchProductsByCategory(String category);
}
