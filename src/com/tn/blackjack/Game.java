package com.tn.blackjack;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by thomasnilsen on 01/05/2017.
 */
public class Game {
    private Dealer dealer;
    private Player[] players;

    public Game(int numOfPlayers) {
        this.dealer = new Dealer();
        this.players = IntStream.rangeClosed(1, numOfPlayers)
                .mapToObj(Player::new)
                .toArray(Player[]::new);
    }

    public void start() {
        dealer.dealInitialTwoCards(players);
        dealer.printStatus();
        Arrays.stream(players).forEach(Player::printStatus);
    }
}
