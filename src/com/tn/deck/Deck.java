package com.tn.deck;

/**
 * Created by thomasnilsen on 01/05/2017.
 */
public interface Deck<T> {
    T dealCard();
    void shuffle();
}
