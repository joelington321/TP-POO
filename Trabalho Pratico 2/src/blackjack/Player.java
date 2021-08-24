package blackjack;

/**
 * A player in a Blackjack game.
 * @author Rick
 */
public class Player extends Person {

    /**
     * Constructs a Player with the name "Unnamed Player".
     * @param blackjack the {@link Blackjack} instance that called
     * this constructor
     */
    public Player(final Blackjack blackjack) {
        this("Unnamed Player", blackjack);
    }

    /**
     * Constructs a Player with the given name.
     * @param name the name this Player is going to get as a 
     * {@link String}, preferably in Title case.
     * @param blackjack the {@link Blackjack} instance that called
     * this constructor
     */
    public Player(final String name, final Blackjack blackjack) {
        super(name, blackjack);
    }

}