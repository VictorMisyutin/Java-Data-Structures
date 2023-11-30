/**
 * The Card class defines a card object for the {@link GoFish} game.
 * 
 * @author CS Professors
 */
public class Card {
    /** The possible suits of a card. */
    public enum Suit {Club, Diamond, Heart, Spade};
    
    /** The {@link Suit} of the card. */
    private Suit suit;

    /** The rank of the card, limited to 2-10. */
    private int rank;

    /**
     * Creates a new Card with a given {@link Suit} and rank.
     * 
     * @param suit The {@link Suit} of the card
     * @param rank The rank of the card
     */
    public Card(Suit suit, int rank) {
        // save the instance variables
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Gets the {@link Suit} of the card.
     * 
     * @return The card's {@link Suit}
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * Gets the rank of the card.
     * 
     * @return The card's rank
     */
    public int getRank() {
        return this.rank;
    }

    public String toString() {
        return "(" + this.rank + "," + this.suit.toString().charAt(0) + ")";
    }
}
