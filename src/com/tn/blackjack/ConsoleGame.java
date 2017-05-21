package com.tn.blackjack;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by thomasnilsen on 01/05/2017.
 */
public class ConsoleGame implements Game {
    private Prompter prompter = new Prompter();
    private Dealer dealer;
    private Player[] players;

    public ConsoleGame() {
        initialize();
    }

    public void start() {
        startInitialDealingOfCards();
        do {
            askPlayersForAction();
            prompter.printStatus(players);
        } while (isPlayersNotDone());

        do {
            dealersTurn();
        } while (isDealerNotDone());
        prompter.printStatus(dealer);
        prompter.printWinners(dealer, players);
    }

    private void initialize() {
        int numberOfPlayers = prompter.ask("Not including the dealer - How many players? ");
        if(numberOfPlayers < 1) {
            throw new IllegalArgumentException("Must be at least 1 player");
        }

        int numberOfDecks = prompter.ask("How many decks should be used? ");
        this.dealer = new Dealer(numberOfDecks);
        this.players = IntStream.rangeClosed(1, numberOfPlayers)
                .mapToObj(Player::new)
                .toArray(Player[]::new);
    }

    @Override
    public void startInitialDealingOfCards() {
        dealer.dealInitialTwoCardsToSelf();
        dealer.dealInitialTwoCards(players);
    }

    @Override
    public void askPlayersForAction() {
        Arrays.stream(players)
                .filter(player -> player.lastAction != Action.STAND && player.getCurrentState() != State.BUST)
                .forEach(player -> {
                    prompter.printStatus(player);
                    player.performAction(prompter.getAction(), dealer.dealCard());
                });
    }

    @Override
    public void dealersTurn() {
        Card card = dealer.dealCard();
        prompter.printStatus(dealer);
        dealer.performAction(null, card);
    }

    private boolean isPlayersNotDone() {
        return Arrays.stream(players).anyMatch(player ->
                player.getCurrentState() != State.BUST &&
                player.lastAction != Action.STAND);
    }

    private boolean isDealerNotDone() {
        return dealer.lastAction != Action.STAND &&
                dealer.getCurrentState() != State.BUST;
    }
}
