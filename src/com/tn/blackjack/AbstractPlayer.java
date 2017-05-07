package com.tn.blackjack;

import com.tn.deck.AbstractOperation;

/**
 * Created by thomasnilsen on 07/05/2017.
 */
public abstract class AbstractPlayer extends AbstractOperation<Card> {

    private boolean containsAce() {
        return hand.stream().anyMatch(card -> card.getRank() == Rank.ACE);
    }

    @Override
    public int calculateScore() {
        int score = hand.stream().mapToInt(card -> card.getRank().getValue()).sum();
        return  score > 21 && containsAce() ?
                score - 10 :
                score;
    }
}
