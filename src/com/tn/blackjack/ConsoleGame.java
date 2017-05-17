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
    }

    public void initialize() {
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
        for (Player player : players) {
            if(player.lastAction == Action.STAND) {
                continue;
            }
            if (player.getCurrentState() != State.BUST) {
                prompter.printStatus(player);
                Action action = prompter.getAction();
                Card card = dealer.dealCardToPlayer();
                player.performAction(action, card);
            }
        }
    }

    @Override
    public void askDealerForAction() {

    }

    private boolean isPlayersNotDone() {
        return Arrays.stream(players).anyMatch(player ->
                player.getCurrentState() != State.BUST &&
                player.lastAction != Action.STAND);
    }
}
