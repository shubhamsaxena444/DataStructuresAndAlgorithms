package LLD.AmazonShoppingCart.shoppingcart;

import LLD.AmazonShoppingCart.constants.OrderStatus;
import LLD.AmazonShoppingCart.payment.Payment;

import java.util.List;

import java.util.Date;

public class Order {
    private String orderNumber;
    private OrderStatus status;
    private Date orderDate;
    private List<OrderLog> orderLog;

    public boolean sendForShipment(){return true;}
    public boolean makePayment(Payment payment){return true;}
    public boolean addOrderLog(OrderLog orderLog){return true;}
}
