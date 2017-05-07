package com.tn.blackjack;

import java.util.Arrays;

/**
 * Created by thomasnilsen on 06/05/2017.
 */
public class Dealer extends Hand {
    private CardDeck deck;

    Dealer() {
        this.deck = new CardDeck(Suit.values(), Rank.values());
    }

    public void startInitialDealingOfCards(Player[] players) {
        Arrays.stream(players).forEach(player -> player.drawCards(deck.dealCard(), deck.dealCard()));
        drawCards(deck.dealCard(), deck.dealCard());
    }

    @Override
    public void status() {
        System.out.printf("%nThe Dealer, has the following hand:%n");
        hand.forEach(Card::print);
        System.out.printf("( score of %d )", calculateScore());
    }

}
