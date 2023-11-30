import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Deck class implements a deck of {@link Card}s for the {@link GoFish} game.
 * 
 * @author CS Professors
 */
public class Deck {
    /** The {@link Card}s in the deck in sequential order. */
    private List<Card> cards;

    /**
     * Creates a new Deck of cards.
     */
    public Deck() {
        // create the instance variables
        this.cards = new ArrayList<Card>();

        // add every card in the deck
        for (Card.Suit suit : Card.Suit.values()) {
            for (int rank = 2; rank < 11; rank++) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }

        // randomly shuffle the deck to start
        this.shuffle();
    }

    /**
     * Randomly shuffles the deck.
     */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    /**
     * Draws a given number of {@link Card}s from the top of the deck.
     * 
     * @param num The number of {@link Card}s to draw
     * 
     * @return The {@code num}{@link Card}s drawn from the top of the deck
     */
    public Card[] drawCards(int num) {
        // make sure we have enough cards available
        if (num > this.cards.size()) {
            throw new IllegalArgumentException("There are not enough cards left to draw " + num + ". Only " + this.cards.size() + " remain.");
        }

        // create an array with the cards drawn from the deck
        Card[] drawn = new Card[num];

        for (int i = 0; i < num; i++) {
            // take from the top of the deck
            drawn[i] = this.cards.remove(0);
        }

        return drawn;
    }

    /**
     * Counts the number of {@link Card}s remaining in the deck.
     * 
     * @return The number of {@link Card}s remaining in the deck
     */
    public int getNumCards() {
        return this.cards.size();
    }
}
