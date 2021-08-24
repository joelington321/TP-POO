package blackjack;

/**
 * The interface to be implemented for creating a
 * view for the {@link Blackjack} game.
 * @author Rick
 */
public interface BlackjackView {

    /**
     * Displays the welcome message and shows the
     * initial hands (by calling {@link #showHand(Person)}) 
     * of all the players.
     */
    public void welcome();

    /**
     * Displays the initial {@link Card} instances in a {@link Person}
     * 's {@link Hand} as it is viewable for the {@link Player}.
     * @param person The {@link Person} to show the {@link Hand}
     * 's contents of.
     */
    public void showInitialHand(Person person);

    /**
     * Displays the {@link Card} instances in one {@link Person}
     * 's {@link Hand} and displays the total value of that
     * {@code Hand}.
     * @param person The {@link Person} to show the {@link Hand}
     * 's contents of.
     */
    public void showHand(Person person);

    /**
     * Asks a {@link Person} if it wants to hit or stay.
     * @param person the {@link Person} the question is asked to
     * @return a {@link String} "hit" or "stay"
     */
    public String askForTurn(Person person);

    /**
     * Displays the total value of a {@link Person}'s {@link Hand}
     * @param person the {@Person} whose total will be displayed
     */
    public void displayTotal(Person person);

    /** 
     * Shows who the winner is
     * @param person the winning {@link Person}
     */
    public void showWinner(Person person);

    /**
     * Asks if the user wants to play again
     * @return {@code true} if the user wants to play again,
     * {@code false} if he doesn't
     */
    public boolean wantToPlayAgain();

    /**
     * Displays a message thanking the user for playing after
     * he says he doesn't want to play again.
     */
    public void thanksForPlaying();
}