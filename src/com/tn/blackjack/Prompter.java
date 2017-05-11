package com.tn.blackjack;

import java.util.Scanner;

/**
 * Created by thomasnilsen on 10/05/2017.
 */
public class Prompter {
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
        } while (!answer.equals("H") && !answer.equals("S"));

        State state;
        switch (answer) {
            case "H": state = State.HIT;
                    break;
            case "S": state = State.STAND;
                    break;
            default: state = null;
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
