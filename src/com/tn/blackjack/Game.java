package com.tn.blackjack;

import java.util.stream.IntStream;

/**
 * Created by thomasnilsen on 01/05/2017.
 */
public class Game {
    private Prompter prompter = new Prompter();
    private Dealer dealer;
    private Player[] players;

    public Game() {
        initializePlayers();
    }

    public void start() {
        dealer.dealInitialTwoCards(players);
        dealer.askPlayerToPerformAction(players);
    }

    private void initializePlayers() {
        int numberOfPlayers = prompter.ask("Not including the dealer - How many players? ");
        this.dealer = new Dealer();
        this.players = IntStream.rangeClosed(1, numberOfPlayers)
                .mapToObj(Player::new)
                .toArray(Player[]::new);

    }
}
