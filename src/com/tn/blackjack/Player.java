package com.tn.blackjack;

/**
 * Created by thomasnilsen on 05/05/2017.
 */
public class Player extends AbstractPlayer {
    private final int id;

    Player(int id) {
        this.id = id;
    }

    public void performAction(Action action, Card card) {
        switch (action) {
            case HIT: drawCards(card);
                break;
        }
    }


    @Override
    public String toString() {
        return id + "";
    }
}
