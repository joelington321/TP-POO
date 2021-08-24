package blackjack;

/**
 * A {@code Person} is someone who sits at the table to play
 * Blackjack.
 * @author Rick
 */
public class Person {
    private final Blackjack blackjack;
    private final String name;
    private Hand hand = new Hand();

    /**
     * Constructs a Person with the name "Unnamed Person".
     * @param blackjack the instance of the game this {@code 
     * Player} is playing
     */
    public Person(final Blackjack blackjack) {
        this("Unnamed Person", blackjack);
    }

    /**
     * Constructs a Person with the given name.
     * @param name the name this Person is going to get as a 
     * {@link String}, preferably in Title case.
     * @param blackjack the {@link Blackjack} instance that called
     * this constructor
     */
    public Person(final String name, final Blackjack blackjack) {
        this.name = name;
        this.blackjack = blackjack;
    }

    /**
     * @return the name as a {@link String} exactly as is
     */
    public String getName() {
        return name;
    }

    /**
     * @return the {@link Hand} this player currently has
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * @return the part of the {@link Hand} that is currently 
     * viewable to the player
     */
    public Hand getOpenHand() {
        return hand;
    }

    /**
     * Puts the {@link Card} in this Player's {@link Hand}.
     * @param card the {@link Card} this {@code Player} is receiving.
     */
    public void receiveCard(final Card card) {
        hand.addCard(card);
    }

    /**
     * A class for when this Person is AI and has to respond
     * by itself instead of waiting for user input.
     * @return an empty {@link String} if this is a user and not 
     * AI, "hit" or "stay" if this is AI.
     */
    public String autoRespondWantToHit() {
        return "";
    }

    /**
     * Asks the game to give this {@code Person} a new {@link Card}
     */
    public void wantsToHit() {
        blackjack.dealCard(this);
    }
}