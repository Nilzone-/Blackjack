package com.tn.blackjack;

/**
 * Created by thomasnilsen on 05/05/2017.
 */
public class Player extends Hand {
    private int id;

    Player(int id) {
        this.id = id;
    }

    @Override
    public void status() {
        System.out.printf("%nPlayer %d, has the following hand:%n", id);
        hand.forEach(Card::print);
        System.out.printf("( score of %d )", calculateScore());
    }
}