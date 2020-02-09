package LLD.Auction;

public class Seller extends User {

    public Seller(String name) {
        super(name);
    }

    int profit;

    float getProfit(Auction auction){
float avg = (float)((auction.getHighestBiddingLimit()+auction.getLowestBiddingAmount())/2.0);
        Bid winner = auction.getHighestUniqueBid();
//       return  (winner!= null ? winner.getAmount():0) +
               return (float)(auction.getParticipationCost()   * 0.2) ;
    }

    void sell(String item, Auction action){

    }

}
