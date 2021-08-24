package blackjack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

/**
 * A {@code Hand} holds a collection of {@link Card} instances.
 * @author Rick
 * @since 1.5
 */
public class Hand {
    private Queue<Card> cards = new PriorityQueue<Card>();

    /**
     * Adds a {@link Card} to the collection.
     * @param card the {@link Card} to be added
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * @return the total value of this {@code Hand} in a Blackjack game.
     * If there are aces, returns the highest value under 22.
     */
    public int getTotal() {
        List<Integer> totals = new ArrayList<Integer>();
        totals.add(new Integer(0));
        for(Card card : cards) {
            for (int i = 0; i < totals.size(); i++) {
                totals.add(i, new Integer(totals.get(i).intValue() + card.getValue()));
                totals.remove(i+1);
            }
            if (card.getRank() == 1) totals.add(new Integer(totals.get(totals.size() - 1) - 10));
        }
        for (Integer total : totals) {
            if (total.intValue() <= 21) return total;
        }
        return totals.get(totals.size()-1).intValue();
    }

    /**
     * @return a {@link Queue} containing the cards in this {@code Hand}
     */
    public Queue<Card> getCards() {
        return cards;
    }
}