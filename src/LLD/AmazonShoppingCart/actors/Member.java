package LLD.AmazonShoppingCart.actors;

public class Member extends Customer {
    private Account account;

    //placeorder
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
