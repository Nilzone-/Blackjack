package com.tn.blackjack;

import com.tn.deck.AbstractHand;

/**
 * Created by thomasnilsen on 07/05/2017.
 */
public abstract class Hand extends AbstractHand<Card> {

    @Override
    public int calculateScore() {
        return hand.stream().mapToInt(card -> card.getRank().getValue()).sum();
    }
}
