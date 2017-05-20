package com.tn.blackjack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thomasnilsen on 10/05/2017.
 */
class Prompter {
    private static final String HIT = "H";
    private static final String STAND = "S";
    private static final String DOUBLE_DOWN = "D";
    private static final String SPLIT = "SP";

    private Scanner scanner = new Scanner(System.in);

    void printStatus(AbstractPlayer player) {
        String p = (player instanceof Player) ? player.toString() : "Dealer";
        System.out.printf("%n ==== %s ==== %n", p);
        player.hand.forEach(this::printObject);
        System.out.printf("( score of %d )", player.calculateScore());
        System.out.printf(player.hasBlackjack() ?
                "\tBLACKJACK" : player.isBust() ?
                "\tBUST" : "\tPLAYABLE");
        System.out.printf("\tLast Action: %s%n", player.lastAction);
    }

    void printStatus(AbstractPlayer[] players) {
        System.out.printf("%n%n********* Current Status ********* %n");
        Arrays.stream(players).forEach(this::printStatus);
        System.out.printf("%n********************************** %n%n");
    }

    void printWinners(Dealer dealer, Player[] players) {
        System.out.printf("%n%n********* End Game Result ********* %n");
        Arrays.stream(players).forEach(player -> {
            System.out.printf("%n Dealer (%d) vs. Player %s (%d) (Winner is: %s)",
                    dealer.calculateScore(),
                    player.toString(),
                    player.calculateScore(),
                    getWinner(dealer, player));
        });
        System.out.printf("%n%n*********************************** %n%n");
    }

    Action getAction() {
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
            case DOUBLE_DOWN: action = Action.DOUBLE_DOWN;
                break;
            case SPLIT: action= Action.SPLIT;
                break;
            default: throw new IllegalStateException();
        }
        return action;
    }

    int ask(String question) {
        String answer;
        do {
            System.out.printf("%s", question);
            answer = scanner.nextLine().trim();
        } while (!isInt(answer));
        return Integer.parseInt(answer);
    }

    private String getWinner(Dealer dealer, Player player) {
        return isPlayerWinner(dealer, player) ? player.toString() : dealer.toString();
    }

    private boolean isPlayerWinner(Dealer dealer, Player player) {
        boolean playerHasRealBlackJackAndDealerDoesNot = player.hasRealBlackjack() && !dealer.hasRealBlackjack();
        boolean playerHasHigherScoreThanDealer = player.getCurrentState() != State.BUST
                && player.calculateScore() > dealer.calculateScore();
        boolean playerScoreIsLessThenDealerButDealerIsBust = player.calculateScore() < dealer.calculateScore()
                && dealer.getCurrentState() == State.BUST;

        return playerHasRealBlackJackAndDealerDoesNot ||
                playerHasHigherScoreThanDealer ||
                playerScoreIsLessThenDealerButDealerIsBust;
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
