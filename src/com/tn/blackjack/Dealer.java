package com.tn.blackjack;

import java.util.Arrays;

/**
 * Created by thomasnilsen on 06/05/2017.
 */
public class Dealer extends AbstractPlayer {
    private CardDeck deck;

    public Dealer(int numberOfDecks) {
        this.deck = new CardDeck(numberOfDecks);
    }

    public void dealInitialTwoCardsToSelf() {
        drawCards(deck.dealCard(), deck.dealCard());
    }

    public Card dealCardToPlayer() {
        return deck.dealCard();
    }

    public void dealInitialTwoCards(Player[] players) {
        Arrays.stream(players).forEach(player -> player.drawCards(deck.dealCard(), deck.dealCard()));
    }

}
