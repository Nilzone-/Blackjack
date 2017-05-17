package com.tn.blackjack;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by thomasnilsen on 01/05/2017.
 */
public class CardDeck {
    private List<Card> deck;

    CardDeck(int numberOfDecks) {
        this.deck = initializeDecks(numberOfDecks, Suit.values(), Rank.values());
        shuffle();
    }

    private List<Card> initializeDecks(Suit[] suits, Rank[] ranks) {
        return Arrays.stream(suits)
                .flatMap(suit -> Arrays.stream(ranks).map(rank -> new Card(suit, rank)))
                .collect(Collectors.toList());
    }

    private List<Card> initializeDecks(int numberOfDecks, Suit[] suits, Rank[] ranks) {
        return IntStream.range(0, numberOfDecks)
                .mapToObj(i -> initializeDecks(suits, ranks))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public Card dealCard() {
        if(deck.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return deck.remove(0);
    }

    private void shuffle() {
        Collections.shuffle(deck);
    }
}
