package com.tn.blackjack;

/**
 * Created by thomasnilsen on 14/05/2017.
 */
interface Game {
    void startInitialDealingOfCards();
    void askPlayersForAction();
    void dealersTurn();
}
