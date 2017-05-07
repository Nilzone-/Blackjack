package com.tn.blackjack;

/**
 * Created by thomasnilsen on 06/05/2017.
 */
public class Dealer extends Hand {
    private CardDeck deck;

    Dealer() {
        this.deck = new CardDeck(Suit.values(), Rank.values());
    }

    public void startInitialDealingOfCards(Player[] players) {
        for(Player player : players) {
            Card[] initialCards = deck.dealCards(2);
            player.drawCards(initialCards);
        }
        Card[] dealersInitialCards = deck.dealCards(2);
        drawCards(dealersInitialCards);
    }

    @Override
    public void status() {
        System.out.printf("%nThe Dealer, has the following hand:%n");
        hand.forEach(Card::print);
        System.out.printf("( score of %d )", calculateScore());
    }

}
