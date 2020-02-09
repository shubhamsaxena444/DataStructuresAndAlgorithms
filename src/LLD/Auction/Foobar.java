package LLD.Auction;

import java.util.ArrayList;
import java.util.List;

public class Foobar {
    static int companyNetProfit;
    static List<Seller> registeredSellers= new ArrayList<>();
    static List<Buyer> registeredBuyers = new ArrayList<>();
    static List<Auction> auctions= new ArrayList<>();

    static Auction createAuction(int id,int lowestBiddingAmount,int highetBiddingLimit,int participationCost,Seller seller) throws AuctionNotCreated {
        //check if auction already exists
        if(auctions.stream().filter(s->s.getId() ==id).count() != 0){
            throw new AuctionNotCreated("Auction already Exists");
        }
        Auction auction = new Auction( id, lowestBiddingAmount, highetBiddingLimit, participationCost, seller);
        //add to auction list
        auctions.add(auction);
    return auction;
    }

    static Seller addSeller(String sellerName){
        Seller seller = new Seller(sellerName);
        //add to company
        registeredSellers.add(seller);

        return seller;
    }

    static Buyer addBuyer(String name){
        Buyer buyer = new Buyer(name);
        //add to buyers list
        registeredBuyers.add(buyer);

        return buyer;
    }
    static int collectCompanyProfit(Auction auction){
        return (int) (auction.getParticipationCost() * 0.8);

    }


    public static void main(String[] args) throws AuctionNotCreated {
        /*addBuyer("amal");
        addSeller("sumit");
        Auction auction = createAuction(1,1,12,100,new Seller("shubham"));


        Buyer buyer = registeredBuyers.get(0);
        if(buyer!=null){

            try {
                buyer.createBid(auction,buyer,2);
            } catch (BidNotCreated bidNotCreated) {
                bidNotCreated.printStackTrace();
            }
            buyer.updateBid(auction,buyer,3);
//            buyer.withdrawBid(auction,buyer,3);
            //update buyer participation and meke prefered accordingly
            buyer.setAuctionsParticipated(buyer.getAuctionsParticipated()+1);
            if(buyer.getAuctionsParticipated() >2){
                buyer.setPreffered(true);
            }
        }

        //close the bidding
        auction.closeBidding();

        //again open the bidding
        auction.openBidding();

        //finall;y close the bidding
        auction.closeBidding();
        //calculate seller profit
       int sellerProfit= auction.getSeller().getProfit(auction);
        System.out.println("seller profit : "+ sellerProfit);
        //calculate company profit
        int companyProfit= collectCompanyProfit(auction);

        System.out.println("company profit : "+ companyProfit);
        //increase company's revenue
        companyNetProfit = companyNetProfit + collectCompanyProfit(auction);

        //find winner
        Bid winner = auction.getHighestUniqueBid();

        System.out.println(winner!=null ? winner.getBuyer().getName():"Nobody won");
*/
        testCase2();
       // testCase1();
    }

    private static void testCase1()throws AuctionNotCreated {
        Buyer buyer1 = addBuyer("buyer2");
        Buyer buyer2 = addBuyer("buyer2");
        Buyer buyer3 = addBuyer("buyer3");
        Seller seller1 = addSeller("seller2");
        Auction auction = createAuction(1,10,50,1,seller1);
        try {
            buyer1.createBid(auction,buyer1,17);

        } catch (BidNotCreated bidNotCreated) {
            bidNotCreated.printStackTrace();
        }
        try {
            buyer2.createBid(auction,buyer2,15);
        } catch (BidNotCreated bidNotCreated) {

        }
            buyer2.updateBid(auction,buyer2,19);

        try {
            buyer3.createBid(auction,buyer3,19);
        } catch (BidNotCreated bidNotCreated) {

        }
        auction.closeBidding();
        System.out.println(seller1.getProfit(auction));
    }

    private static void testCase2() throws AuctionNotCreated {
        Seller seller2 = addSeller("seller2");
        Auction auction = createAuction(2,5,20,2,seller2);
        Buyer buyer2 = addBuyer("buyer2");
        Buyer buyer3 = addBuyer("buyer3");
        try {
            buyer3.createBid(auction,buyer3,25);

        } catch (BidNotCreated bidNotCreated) {
            bidNotCreated.printStackTrace();
        }
        try {
            buyer2.createBid(auction,buyer2,5);
        } catch (BidNotCreated bidNotCreated) {

        }
        buyer2.withdrawBid(auction,buyer2,0);
        auction.closeBidding();
        System.out.println(seller2.getProfit(auction));
    }


}
