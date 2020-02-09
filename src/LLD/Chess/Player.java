package LLD.Chess;

import LLD.AmazonShoppingCart.actors.Account;

public class Player extends Account {
    private Constant.Person person;
    private boolean whiteSide = false;

    public Player(Constant.Person person, boolean whiteSide){
        this.person = person;
        this.whiteSide = whiteSide;
    }

    public boolean isWhiteSide() {
        return this.whiteSide == true;
    }
}