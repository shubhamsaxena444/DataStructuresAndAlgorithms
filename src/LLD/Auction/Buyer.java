package LLD.Auction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Buyer extends User {
    private int numberOfAuctionsParticipated;
    private boolean isPreffered;
    private int  auctionsParticipated;
    //
    private List<Bid> bids = new ArrayList<>();


    public Buyer(String name) {
        super(name);
    }

    Bid createBid(Auction auction, Buyer buyer, int amount) throws BidNotCreated {
    //validate to ensure uniqueness of bid
        if(auction.getAuctionStatus()!=AuctionStatus.ACTIVE){
            throw new BidNotCreated("Bid Already exists");

        }
        //validate if the bidding amount is valid
        if(amount > auction.getHighestBiddingLimit() || amount<auction.getLowestBiddingAmount()){
            throw new BidNotCreated("Bidding amount is invalid");
        }

        List<Bid> existingBid = auction.getBids().stream().filter(x -> x.getBuyer() == buyer).collect(Collectors.toList());
        if(existingBid.size()!=0){
            return existingBid.get(0);
        }
        //else create a fresh bid
        Bid bid = new Bid(auction,buyer,amount);
        //track buyer bids
        this.getBids().add(bid);
        //participate in auction
        this.participate(auction.getParticipationCost(),auction,bid);
            this.numberOfAuctionsParticipated+=1;
            if(this.numberOfAuctionsParticipated>2)
                isPreffered=true;
         return bid;
    }

    void updateBid(Auction auction,Buyer buyer,int amount) {
        List<Bid> bid = auction.getBids().stream().filter(x -> x.getBuyer() == buyer).collect(Collectors.toList());
        try {
            if (bid.size() != 0) {
                bid.get(0).setAmount(amount);
            } else {
                throw new BidNotFoundException("Bid Not found");
            }
        }catch (BidNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    void withdrawBid(Auction auction,Buyer buyer,int amount){
        List<Bid> bid = auction.getBids().stream().filter(x -> x.getBuyer() == buyer).collect(Collectors.toList());
        try {
            if (bid.size() != 0) {
                buyer.getBids().remove(bid);
                auction.getBids().remove(bid);
            } else {
                throw new BidNotFoundException("Bid Not found");
            }
        }catch (BidNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    void participate(int participationCost, Auction auction,Bid bid){
            auction.getBids().add(bid);
    }



    public int getNumberOfAuctionsParticipated() {
        return numberOfAuctionsParticipated;
    }

    public void setNumberOfAuctionsParticipated(int numberOfAuctionsParticipated) {
        this.numberOfAuctionsParticipated = numberOfAuctionsParticipated;
    }

    public boolean isPreffered() {
        return isPreffered;
    }

    public void setPreffered(boolean preffered) {
        isPreffered = preffered;
    }

    public int getAuctionsParticipated() {
        return auctionsParticipated;
    }

    public void setAuctionsParticipated(int auctionsParticipated) {
        this.auctionsParticipated = auctionsParticipated;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}
