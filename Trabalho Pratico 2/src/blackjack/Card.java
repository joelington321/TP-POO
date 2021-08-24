package blackjack;

/**
 * Enumeration of all possible {@code Card} values and ranks.
 * @author Rick
 * @since 1.5
 */
public enum Card implements Comparable<Card> {

    ACE    (1,11),
    KING       (13,10),
    QUEEN  (12,10),
    JACK       (11,10),
    TEN    (10,10),
    NINE       (9,9),
    EIGHT  (8,8),
    SEVEN  (7,7),
    SIX    (6,6),
    FIVE       (5,5),
    FOUR   (4,4),
    THREE  (3,3),
    TWO    (2,2);

    private final int rank;
    private final int value;

    /**
     * @param rank an {@code int} to signify the rank
     * @param value the value of this rank in a Blackjack game.
     * The value of 1 for an Ace is excluded here and should be 
     * treated as a special case elsewhere.
     */
    private Card(final int rank, final int value) {
        this.rank = rank;
        this.value = value;
    }

    /**
     * @return an {@code int} to signify the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @return the value of this rank in a Blackjack game.
     * The value of 1 for an Ace is excluded here and should be 
     * treated as a special case elsewhere.
     */
    public int getValue() {
        return value;
    }
}