package com.tn.blackjack;

/**
 * Created by thomasnilsen on 05/05/2017.
 */
public class Player extends AbstractPlayer {
    private final int id;
    private Action lastAction;

    Player(int id) {
        this.id = id;
    }

    public Action getLastAction() {
        return lastAction;
    }

    @Override
    public void performAction(Action action, Card card) {
        switch (action) {
            case HIT: drawCards(card);
                break;
        }
        lastAction = action;
    }

    @Override
    public String toString() {
        return id + "";
    }

}
