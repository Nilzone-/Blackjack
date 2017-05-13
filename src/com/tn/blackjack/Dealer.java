package com.tn.blackjack;

import java.util.Arrays;

/**
 * Created by thomasnilsen on 06/05/2017.
 */
public class Dealer extends AbstractPlayer {
    private CardDeck deck;

    public Dealer(int numberOfDecks) {
        initialize(numberOfDecks);
    }

    public void dealInitialTwoCards(Player[] players) {
        Arrays.stream(players).forEach(player -> player.drawCards(deck.dealCard(), deck.dealCard()));
        drawCards(deck.dealCard(), deck.dealCard());
    }

    public void startPlayerLoop(Player[] players) {
        Arrays.stream(players).forEach(player -> player.performAction(deck));
    }

    private void initialize(int numberOfDecks) {
        if(numberOfDecks < 1) {
            throw new IllegalArgumentException("Deck size must be at least 1");
        }
        this.deck = new CardDeck(numberOfDecks);
    }

}
