package com.tn.deck;

/**
 * Created by thomasnilsen on 03/05/2017.
 */
public interface Suitable<T> {
    boolean isSameSuit(T other);
}
