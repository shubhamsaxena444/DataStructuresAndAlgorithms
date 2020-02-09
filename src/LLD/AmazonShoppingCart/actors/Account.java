package LLD.AmazonShoppingCart.actors;

import LLD.AmazonShoppingCart.constants.AccountStatus;
import LLD.AmazonShoppingCart.constants.Address;
import LLD.AmazonShoppingCart.inventory.Product;
import LLD.AmazonShoppingCart.inventory.ProductReview;
import LLD.AmazonShoppingCart.payment.CreditCard;
import LLD.AmazonShoppingCart.payment.ElectronicBankTransfer;
import java.util.List;

public class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private String name;
    private Address shippingAddress;
    private String email;
    private String phone;

    private List<CreditCard> creditCards;
    private List<ElectronicBankTransfer> bankAccounts;

    public boolean addProduct(Product product){return true;}
    public boolean addProductReview(ProductReview review){return true;}
    public boolean resetPassword(){return true;}
 //addproductreview
    //addproduct

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
