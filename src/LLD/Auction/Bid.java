package LLD.Auction;

public class Bid {
    private int id;
    private Auction auction;
    private Buyer buyer;
    private int amount;

    public Bid(Auction auction, Buyer buyer, int amount) {
        this.auction = auction;
        this.buyer = buyer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



}
