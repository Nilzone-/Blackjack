package com.tn.blackjack;

import java.util.Scanner;

/**
 * Created by thomasnilsen on 10/05/2017.
 */
public class Prompter {
    private static final String HIT = "H";
    private static final String STAND = "S";
    private Scanner scanner = new Scanner(System.in);

    public void printStatus(AbstractPlayer player) {
        player.hand.forEach(Card::print);
        System.out.printf("( score of %d )", player.calculateScore());
        System.out.printf(player.hasBlackjack() ?
                "\tBLACKJACK" : player.isBust() ?
                "\tBUST" : "");
    }

    public State getState() {
        String answer;
        do {
            System.out.printf("%n%nDo you want to (H)it or (S)tand? ");
            answer = scanner.nextLine().trim().toUpperCase();
        } while (!answer.equals(HIT) && !answer.equals(STAND));

        State state;
        switch (answer) {
            case HIT: state = State.HIT;
                    break;
            case STAND: state = State.STAND;
                    break;
            default: throw new IllegalStateException();
        }
        return state;
    }

    public int ask(String question) {
        String answer;
        do {
            System.out.printf("%s", question);
            answer = scanner.nextLine().trim();
        } while (!isInt(answer));
        return Integer.parseInt(answer);
    }

    private static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
