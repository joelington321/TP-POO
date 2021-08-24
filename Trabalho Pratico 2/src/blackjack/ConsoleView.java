package blackjack;

import java.util.Queue;
import java.util.Scanner;

/**
 * The view of this game in a console window.
 * @author Rick
 * @since 1.5
 */
public class ConsoleView implements BlackjackView{
    private Scanner keyboard = new Scanner(System.in);

    /**
     * Constructs a new view for the given {@link Blackjack} instance.
     * 
     * @param blackjack the {@link Blackjack} instance for this view.
     */
    public ConsoleView(Blackjack blackjack) {
    }

    @Override
    public void welcome() {
        System.out.println("\n\n\nWelcome to a new Blackjack game!\n\n");
    }

    @Override
    public void showInitialHand(Person person) {
        Hand hand = person.getOpenHand();
        Queue<Card> cards = hand.getCards();
        System.out.println(person.getName() + " has " + HandDisplay.cardsToString(cards) + ".\n");
        return;
    }

    @Override
    public void showHand(Person person) {
        Hand hand = person.getHand();
        Queue<Card> cards = hand.getCards();
        System.out.println(person.getName() + " has " + HandDisplay.cardsToString(cards) + ".");
        System.out.println("That makes a total of " + hand.getTotal() + ".\n");
    }

    public String askForTurn(Person person) {
        System.out.print("Do you want to 'hit' or 'stay'? ");
        String aiResponse = person.autoRespondWantToHit();
        if (aiResponse.length() > 0) {
            System.out.print(aiResponse + "\n");
            return aiResponse;
        }
        return keyboard.nextLine();
    }

    public void displayTotal(Person person) {
        System.out.println(person.getName() + "'s total is " + person.getHand().getTotal() + ".");
    }

    public void showWinner(Person person) {
        System.out.println(person.getName() + " is the winner!\n");
    }

    public boolean wantToPlayAgain() {
        System.out.print("\nDo you want to play again? 'y'/'n': ");
        String input = keyboard.nextLine();
        if (input.equals("y") || input.equals("n")) {
            return (input.equals("y"));
        }
        return wantToPlayAgain();
    }

    public void thanksForPlaying() {
        System.out.println("\nThanks for playing!");
    }
}