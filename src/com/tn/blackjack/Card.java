package com.tn.blackjack;

import com.tn.deck.Rankable;
import com.tn.deck.Suitable;

/**
 * Created by thomasnilsen on 01/05/2017.
 */

public class Card implements Suitable<Card>, Rankable<Card> {
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

    public void print() {
        System.out.printf("%s%s ", suit.getIcon(), rank.getName());
    }

    @Override
    public boolean isConsecutive(Card other) {
        return Math.abs(rank.getValue() - other.getRank().getValue()) == 1;
    }

    @Override
    public boolean isSameSuit(Card other) {
        return suit.equals(other.suit);
    }
}
