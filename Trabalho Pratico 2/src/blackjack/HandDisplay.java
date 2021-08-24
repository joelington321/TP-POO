package blackjack;

import java.util.Collections;
import java.util.Queue;
import java.util.PriorityQueue;

/**
 * A utility class helping to display the cards in a {@link Hand} in plain English.
 * @author Rick
 * @since 1.5
 */
public final class HandDisplay {

    /** An array of the English names of playing cards.  */
    public static final String[] CARD_NAMES = {"joker","ace","two","three","four","five","six","seven","eight","nine","ten","jack","queen","king"};
    /** An array of the English names of playing cards in plural form.  */
    public static final String[] CARD_NAMES_PLURAL = {"jokers","aces","twos","threes","fours","fives","sixes","sevens","eights","nines","tens","jacks","queens","kings"};

    /**
     * Creates a {@link String} displaying the contents of a {@link Queue} of {@link Card} instances.
     * @param cards a {@link Queue} containing zero or more {@link Card} instances.
     * @return a {@link String} describing the cards in plain English, or "nothing" if there are zero cards.
     */
    public static String cardsToString(final Queue<Card> cards) {
        if (cards.size() == 0) return "nothing";

        StringBuilder sb = new StringBuilder(34);
        PriorityQueue<Card> cardsCopy = new PriorityQueue<Card>(cards);

        while (cardsCopy.size() > 0) {
            Card card = cardsCopy.remove();
            int amountOfSameRank = 1 + Collections.frequency(cardsCopy, card);
            for (int j = 1; j < amountOfSameRank; j++) { // also remove all other Card instances with the same rank
                cardsCopy.remove(card);
            }

            sb.append(amountOfSameRank + " " + ( amountOfSameRank == 1 ? CARD_NAMES[card.getRank()] : CARD_NAMES_PLURAL[card.getRank()] ));

            switch (cardsCopy.size()) {
                case 0:      break;
                case 1:      sb.append(" and ");
                         break;
                default: sb.append(", ");
                         break;
            }
        }
        if (cards.size() == 1) sb.append(" and a hidden card");
        return sb.toString();
    }
}