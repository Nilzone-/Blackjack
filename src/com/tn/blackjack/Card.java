package com.tn.blackjack;

/**
 * Created by thomasnilsen on 01/05/2017.
 */

class Card {
    private final Suit suit;
    private final Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    Suit getSuit() {
        return suit;
    }

    Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return suit.getIcon() + "" + rank.getName() + " ";
    }
}
