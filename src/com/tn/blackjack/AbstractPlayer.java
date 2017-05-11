package com.tn.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thomasnilsen on 07/05/2017.
 */
public abstract class AbstractPlayer {
    static final int WINNING_NUMBER = 21;
    List<Card> hand = new ArrayList<>();

    final void drawCards(Card... cards) {
        hand.addAll(Arrays.asList(cards));
    }

    final boolean hasBlackjack() {
        return calculateScore() == WINNING_NUMBER;
    }

    final int calculateScore() {
        int score = hand.stream().mapToInt(card -> card.getRank().getValue()).sum();
        return score > WINNING_NUMBER && containsAce() ?
                score - 10 : //Takes care of ace being either 1 or 11
                score;
    }

    public abstract void printStatus();


    private boolean containsAce() {
        return hand.stream().anyMatch(card -> card.getRank() == Rank.ACE);
    }

}
