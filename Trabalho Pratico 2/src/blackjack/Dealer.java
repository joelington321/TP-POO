package blackjack;

import java.util.Random;

/**
 * The Dealer in a Blackjack game.
 * @author Rick
 */
public class Dealer extends Person {
    private static final int CUSP = 16;

    /**
     * Creates a new {@code Dealer} with name "The Dealer".
     * @param blackjack the {@link Blackjack} instance that called
     * this constructor
     */
    public Dealer(final Blackjack blackjack) {
        super("The Dealer", blackjack);
    }

    /**
     * Only returns a {@link Hand} with the open {@link Card} 
     * that all {@link Player} instances can see.
     * @return a {@link Hand} with the {@link Dealer}'s first
     * {@link Card} in it
     */
    @Override
    public Hand getOpenHand() {
        Hand hand = new Hand();
        hand.addCard(super.getHand().getCards().peek());
        return hand;
    }

    public String autoRespondWantToHit() {
        if (this.getHand().getTotal() == CUSP) {
            return (new Random().nextBoolean() ? "hit" : "stay");
        }
        return (this.getHand().getTotal() < CUSP ? "hit" : "stay");
    }
}