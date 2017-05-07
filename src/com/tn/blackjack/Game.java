package com.tn.blackjack;

import java.util.Arrays;

/**
 * Created by thomasnilsen on 01/05/2017.
 */
public class Game {
    private Dealer dealer;
    private Player[] players;

    public Game() {
        this.dealer = new Dealer();
        this.players = new Player[] {
                new Player(1),
                new Player(2)
        };
    }

    public void start() {
        dealer.dealInitialTwoCards(players);
        dealer.printStatus();
        Arrays.stream(players).forEach(Player::printStatus);
    }
}
