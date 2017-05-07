package com.tn.deck;

/**
 * Created by thomasnilsen on 04/05/2017.
 */
public interface Rankable<T> {
    boolean isConsecutive(T other);
}
