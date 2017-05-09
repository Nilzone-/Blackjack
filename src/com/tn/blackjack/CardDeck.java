package com.tn.blackjack;

import com.tn.deck.Deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by thomasnilsen on 01/05/2017.
 */
public class CardDeck implements Deck<Card> {
    private List<Card> deck = initializeDeckWith(Suit.values(), Rank.values());
    private List<Card> dealtCards =  new ArrayList<>();

    CardDeck() {
        shuffle();
    }

    private List<Card> initializeDeckWith(Suit[] suits, Rank[] ranks) {
        return Arrays.stream(suits)
                .flatMap(suit -> Arrays.stream(ranks).map(rank -> new Card(suit, rank)))
                .collect(Collectors.toList());
    }

    @Override
    public Card dealCard() {
        if(deck.size() < 1) {
            throw new IllegalStateException("Deck is empty");
        }
        Card card = deck.get(0);
        deck.remove(0);
        dealtCards.add(card);

        return card;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(deck);
    }
}
