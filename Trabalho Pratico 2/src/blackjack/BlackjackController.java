package blackjack;

/**
 * The controller of the Blackjack game.
 * For each new game it creates an instance of {@link Blackjack}
 * and one instance of a {@link ConsoleView}.
 * @author Rick
 */
public class BlackjackController {
    private Blackjack blackjack;
    private BlackjackView view;

    /**
     * Creates an instance of this class and calls {@link #run()}.
     * @param args the default parameter; no arguments needed
     */
    public static void main(String[] args) {
        BlackjackController game = new BlackjackController();
        game.run();
    }

    /**
     * Runs the game in chronological order.
     */
    private void run() {
        do {
            playOneGame();
        } while (view.wantToPlayAgain());
        view.thanksForPlaying();
    }

    private void playOneGame() {
        blackjack = Blackjack.initializeGame();
        blackjack.addPlayers("Player 1");
        blackjack.dealInitialCards();

        view = new ConsoleView(blackjack);
        view.welcome();
        for (Person person : blackjack.getPlayers()) {
            view.showInitialHand(person);
        }
        for (Person person : blackjack.getPlayers()) {
            letPersonPlayItsTurns(person);
        }
        for (Person person : blackjack.getPlayers()) {
            view.displayTotal(person);
        }
        Person winner = blackjack.getWinner();
        view.showWinner(winner);
    }

    private void letPersonPlayItsTurns(Person person) {
        view.showHand(person);

        boolean playOn = true;
        while (playOn) {
            String userInput = "";
            playOn = false;
            do {
                userInput = view.askForTurn(person);
                if (userInput.equals("hit")) {
                    playOn = true;
                }
            } while (!(userInput.equals("hit") || userInput.equals("stay")));

            if (playOn) person.wantsToHit();
            view.showHand(person);
        }
    }

}