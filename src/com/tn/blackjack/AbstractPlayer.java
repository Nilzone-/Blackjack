package com.tn.blackjack;

import java.util.*;

/**
 * Created by thomasnilsen on 07/05/2017.
 */
public abstract class AbstractPlayer {
    private static final int WINNING_NUMBER = 21;
    List<Card> hand = new ArrayList<>();

    private boolean containsAce() {
        return hand.stream().anyMatch(card -> card.getRank() == Rank.ACE);
    }

    private int countAces() {
        return (int) hand.stream().filter(card -> card.getRank() == Rank.ACE).count();
    }

    final void drawCards(Card... cards) {
        hand.addAll(Arrays.asList(cards));
    }

    final boolean isBust() {
        return calculateScore() > WINNING_NUMBER;
    }

    final boolean hasBlackjack() {
        return calculateScore() == WINNING_NUMBER;
    }

    final State getCurrentState() {
        return isBust() ? State.BUST : hasBlackjack() ? State.BLACKJACK : State.PLAYABLE;
    }

    final int calculateScore() {
        int score = hand.stream().mapToInt(card -> card.getRank().getValue()).sum();
        if(score > WINNING_NUMBER && containsAce()) {
            int numberOfAces = countAces();
            while(numberOfAces-- > 0) {
                score -= 10;
                if(score <= WINNING_NUMBER) {
                    break;
                }
            }
        }
        return score;
    }

    public abstract void performAction(Action action, Card card);

}
