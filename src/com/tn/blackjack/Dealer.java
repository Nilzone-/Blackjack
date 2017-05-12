package com.tn.blackjack;

import java.util.Arrays;

/**
 * Created by thomasnilsen on 06/05/2017.
 */
public class Dealer extends AbstractPlayer {
    private Prompter prompter = new Prompter();
    private CardDeck deck;

    Dealer() {
        initializeDeck();
    }

    public void dealInitialTwoCards(Player[] players) {
        Arrays.stream(players).forEach(player -> player.drawCards(deck.dealCard(), deck.dealCard()));
        drawCards(deck.dealCard(), deck.dealCard());
    }

    public void startPlayerLoop(Player[] players) {
        Arrays.stream(players).forEach(player -> player.performAction(deck));
    }

    private void initializeDeck() {
        int numberOfDecks = prompter.ask("How many decks should be used? ");
        if(numberOfDecks < 1) {
            throw new IllegalArgumentException("Deck size must be at least 1");
        }

        this.deck = numberOfDecks > 1 ?
                new CardDeck(numberOfDecks) :
                new CardDeck();
    }

}
