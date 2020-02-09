package LLD.Auction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Auction {
    private  int id;

    private Seller seller;
    private int participationCost;
    private int lowestBiddingAmount;
    private int highestBiddingLimit;
    private AuctionStatus auctionStatus;
    private  List<Bid> bids = new ArrayList<>();

    public Auction(int id, int lowestBiddingAmount, int highetBiddingLimit, int participationCost, Seller seller) {
        this.id =id;
        this.lowestBiddingAmount=lowestBiddingAmount;
        this.highestBiddingLimit =highetBiddingLimit;
        this.participationCost =participationCost;
        this.seller = seller;
        this.auctionStatus = AuctionStatus.ACTIVE;
    }

    void closeBidding(){
        this.auctionStatus = AuctionStatus.BIDDING_CLOSED;
    }

    void openBidding(){
        this.auctionStatus = AuctionStatus.ACTIVE;
    }

    Bid getHighestUniqueBid() {

        if (this.auctionStatus == AuctionStatus.BIDDING_CLOSED) {
            //sort the bids according in decreasing order of amount
            Collections.sort(this.bids, new Comparator<Bid>() {
                @Override
                public int compare(Bid o1, Bid o2) {
                    return o2.getAmount() - o1.getAmount();
                }
            });

            int uniqueBid;
            //iterate till unique bid is found
            for (int i = 0; i < this.bids.size() ; i++) {
                Bid bid = this.bids.get(i);
                if (i + 1 < this.bids.size() && bid != this.bids.get(i + 1)) {
                    return bid;
                } else {
                    List<Bid> tiedBids = new ArrayList<>();
                    tiedBids.add(bid);
                    //if there is a tie, find all equal bidders  and chose Prefered user return bid
                    while (i + 1 < this.bids.size() && this.bids.get(i + 1).getAmount() == bid.getAmount()) {
                        tiedBids.add(this.bids.get(i + 1));
                        i++;
                    }
                    //if only one bid
                    if(tiedBids.size()==1){
                        return tiedBids.get(0);
                    }
                    //filter preferred buyers
                    List<Bid> filteredList = tiedBids.stream().filter(x -> x.getBuyer().isPreffered()).collect(Collectors.toList());
                    //if only one prefered buyer
                    if (filteredList.size() == 1) {
                        return filteredList.get(0);
                    }
                }
            }

            this.auctionStatus = AuctionStatus.FINISHED;
            return null;
        }else{
            System.out.println("Invalid auction state");
            return null;
        }

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParticipationCost() {
        return participationCost;
    }

    public void setParticipationCost(int participationCost) {
        this.participationCost = participationCost;
    }

    public int getLowestBiddingAmount() {
        return lowestBiddingAmount;
    }

    public void setLowestBiddingAmount(int lowestBiddingAmount) {
        this.lowestBiddingAmount = lowestBiddingAmount;
    }

    public int getHighestBiddingLimit() {
        return highestBiddingLimit;
    }

    public void setHighestBiddingLimit(int highestBiddingLimit) {
        this.highestBiddingLimit = highestBiddingLimit;
    }

    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(AuctionStatus auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

}
