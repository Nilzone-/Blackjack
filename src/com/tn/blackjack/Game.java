package com.tn.blackjack;

import java.util.stream.IntStream;

/**
 * Created by thomasnilsen on 01/05/2017.
 */
public class Game {
    private Dealer dealer;
    private Player[] players;

    public Game(Dealer dealer, int numberOfPlayers) {
        this.dealer = dealer;
        initialize(numberOfPlayers);
    }

    public void start() {
        dealer.dealInitialTwoCards(players);
        dealer.startPlayerLoop(players);
    }

    private void initialize(int numberOfPlayers) {
        if(numberOfPlayers < 1) {
            throw new IllegalArgumentException("Must be at least 1 player");
        }
        this.players = IntStream.rangeClosed(1, numberOfPlayers)
                .mapToObj(Player::new)
                .toArray(Player[]::new);
    }
}
