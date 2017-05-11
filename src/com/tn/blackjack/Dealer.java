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

    public void askPlayerToPerformAction(Player[] players) {
        for(Player player : players) {
            player.printStatus();
            State state = State.UNDEFINED;

            while (state != State.STAND) {
                state = prompter.getState();
                switch (state) {
                    case HIT: player.drawCards(deck.dealCard());
                        break;
                    default:
                        break;
                }
                player.printStatus();
                if(player.calculateScore() > WINNING_NUMBER) {
                    break;
                }
            }
        }
    }

    @Override
    public void printStatus() {
        System.out.printf("%nThe Dealer, has the following hand:%n");
        hand.forEach(Card::print);
        System.out.printf("( score of %d )", calculateScore());
    }

    private void initializeDeck() {
        int numberOfDecks = prompter.ask("How many decks should be used? ");
        if(numberOfDecks < 1) {
            throw new IllegalArgumentException("Deck size must be at leat 1");
        }

        this.deck = numberOfDecks > 1 ?
                new CardDeck(numberOfDecks) :
                new CardDeck();
    }

}
