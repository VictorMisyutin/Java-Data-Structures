/**
 * The Player interface defines the methods that all players should implement
 * for the {@link GoFish} game.
 * 
 * @author CS Professors
 */
public interface Player {
    /**  
     * Decides what rank the player asks from the opponent.
     */
    public int decideRank();

    /**
     * Handles an ask from another player.  Removes any {@link Card}s from the player's hand
     * of a given rank and returns those {@link Card}s so they can be given to the opponent.
     * 
     * @param rank The requested rank
     * 
     * @return Any {@link Card}s of {@code rank{ from the players hand
     */
    public Card[] requestCards(int rank);

    /**
     * Adds {@link Card}s to the player's hand.
     * 
     * @param cards The {@link Card}s to add to the player's hand
     */
    public void gainCards(Card[] cards);

    /**
     * Checks if the player has scored any books (i.e., four-of-a-kind).  If so, they are
     * removed from the player's hand.
     */
    public void checkBooks();

    /**
     * Gets the number of {@link Card}s in the player's hand.
     * 
     * @return The number of {@link Card}s in the player's hand
     */
    public int getNumCards();

    /**
     * Gets the number of books that the player has scored.
     * 
     * @return The book count for the player
     */
    public int getBookScore();
}