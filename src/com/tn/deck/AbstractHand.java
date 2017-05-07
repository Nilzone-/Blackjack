package com.tn.deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thomasnilsen on 06/05/2017.
 */
public abstract class AbstractHand<T extends Suitable & Rankable> {
    protected List<T> hand = new ArrayList<>();

    public void drawCard(T o) {
        hand.add(o);
    }

    public void drawCards(T[] o) {
        hand.addAll(Arrays.asList(o));
    }

    public abstract void status();
    public abstract int calculateScore();
}
