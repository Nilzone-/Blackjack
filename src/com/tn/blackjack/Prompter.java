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
        if(player instanceof Player) {
            System.out.printf("%n ==== Player %s ==== %n", player.toString());
        } else {
            System.out.printf("Dealer%n");
        }
        player.hand.forEach(this::printObject);
        System.out.printf("( score of %d )", player.calculateScore());
        System.out.printf(player.hasBlackjack() ?
                "\tBLACKJACK%n" : player.isBust() ?
                "\tBUST%n" : "%n");
    }

    public Action getAction() {
        String answer;
        do {
            System.out.printf("%n%nDo you want to (H)it or (S)tand? ");
            answer = scanner.nextLine().trim().toUpperCase();
        } while (!answer.equals(HIT) && !answer.equals(STAND));

        Action action;
        switch (answer) {
            case HIT: action = Action.HIT;
                    break;
            case STAND: action = Action.STAND;
                    break;
            default: throw new IllegalStateException();
        }
        return action;
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

    private void printObject(Object o) {
        System.out.print(o.toString());
    }
}
