package com.tn.blackjack;

/**
 * Created by thomasnilsen on 05/05/2017.
 */
public class Player extends AbstractPlayer {
    private Prompter prompter = new Prompter();
    private int id;

    Player(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void performAction(Card card) {
        System.out.printf("%n%n==== Player %d ====%n%n", getId());
        State state;
        do {
            prompter.printStatus(this);
            state = prompter.getState();
            switch (state) {
                case HIT: drawCards(card);
                    break;
                default:
                    break;
            }
            if(isBust() || hasBlackjack()) {
                prompter.printStatus(this);
                break;
            }

        } while(state == State.HIT);
    }
}
