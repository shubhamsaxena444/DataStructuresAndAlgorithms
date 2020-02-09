package LLD.AmazonShoppingCart.shipping;

import LLD.AmazonShoppingCart.actors.Account;

import java.util.Date;

public class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public boolean sendNotification(Account account){return true;}
}
