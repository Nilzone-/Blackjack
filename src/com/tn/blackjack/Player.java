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

    public void performAction(CardDeck deck) {
        System.out.printf("%n%n==== Player %d ====%n%n", getId());
        State state;
        do {
            prompter.printStatus(this);

            if(hasBlackjack()) {
                return;
            }

            state = prompter.getState();
            switch (state) {
                case HIT: drawCards(deck.dealCard());
                    break;
                default:
                    break;
            }

            if(isBust() || hasBlackjack()) {
                prompter.printStatus(this);
                return;
            }
        } while(state == State.HIT);
    }
}
