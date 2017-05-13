import com.tn.blackjack.Dealer;
import com.tn.blackjack.Game;
import com.tn.blackjack.Prompter;

public class Main {

    public static void main(String[] args) {
        Prompter prompter = new Prompter();
        int numberOfPlayers = prompter.ask("Not including the dealer - How many players? ");
        int numberOfDecks = prompter.ask("How many decks should be used? ");
        Dealer dealer = new Dealer(numberOfDecks);
        Game blackJack = new Game(dealer, numberOfPlayers);

        blackJack.start();
    }
}
