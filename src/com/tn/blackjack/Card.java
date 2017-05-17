package com.tn.blackjack;

/**
 * Created by thomasnilsen on 01/05/2017.
 */

public class Card {
    private final Suit suit;
    private final Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return suit.getIcon() + "" + rank.getName() + " ";
    }
}
