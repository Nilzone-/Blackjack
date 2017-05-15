package com.tn.blackjack;

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
        startInitialDealingOfCards();
    }

    public void start() {
        startPlayerLoop();
    }

    @Override
    public void initialize() {
        int numberOfPlayers = prompter.ask("Not including the dealer - How many players? ");
        if(numberOfPlayers < 1) {
            throw new IllegalArgumentException("Must be at least 1 player");
        }

        int numberOfDecks = prompter.ask("How many decks should be used? ");
        if(numberOfDecks < 1) {
            throw new IllegalArgumentException("Must be at least 1 deck");
        }

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
    public void startPlayerLoop() {
        for (Player player : players) {
            prompter.printStatus(player);
            if (player.getCurrentState() == State.PLAYABLE) {
                Action action = prompter.getAction();
                Card card = dealer.dealCardToPlayer();

                if(action == Action.STAND) {
                    continue;
                }

                player.performAction(action, card);
                prompter.printStatus(player);
            }
        }
    }


}
