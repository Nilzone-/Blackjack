package com.tn.blackjack;

import java.util.Arrays;

/**
 * Created by thomasnilsen on 06/05/2017.
 */
public class Dealer extends AbstractPlayer {
    //Dealer must hit until he hits 17 or more
    private static final int MINIMUM_SCORE = 17;
    private CardDeck deck;

    Dealer(int numberOfDecks) {
        if(numberOfDecks < 1) {
            throw new IllegalArgumentException("Must be at least 1 deck");
        }
        this.deck = new CardDeck(numberOfDecks);
    }

    void dealInitialTwoCardsToSelf() {
        drawCards(deck.dealCard(), deck.dealCard());
    }

    Card dealCard() {
        return deck.dealCard();
    }

    void dealInitialTwoCards(Player[] players) {
        Arrays.stream(players).forEach(player -> player.drawCards(deck.dealCard(), deck.dealCard()));
    }

    @Override
    public void performAction(Action action, Card... card) {
        int score = calculateScore();
        if (score < MINIMUM_SCORE) {
            drawCards(card);
            lastAction = Action.HIT;
        } else {
            lastAction = Action.STAND;
        }
    }

    @Override
    public String toString() {
        return "The Dealer";
    }
}
