package com.tn.deck;

/**
 * Created by thomasnilsen on 01/05/2017.
 */
public interface Deck<T extends Suitable & Rankable> {
    T dealCard();
    void shuffle();
}
