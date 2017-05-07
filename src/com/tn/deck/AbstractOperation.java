package com.tn.deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thomasnilsen on 06/05/2017.
 */
public abstract class AbstractOperation<T extends Suitable & Rankable> {
    protected List<T> hand = new ArrayList<>();

    @SafeVarargs
    public final void drawCards(T... o) {
        hand.addAll(Arrays.asList(o));
    }

    public abstract void printStatus();
    public abstract int calculateScore();
}
