
public abstract class AbstractPlayer implements Player{
    
    /** The {@link Player}'s hand of {@link Card}s. */
    protected Card[] hand;
    
    /** The number of books (i.e,, four-of-a-kind) the {@link Player} has acquired. */
    protected int bookScore;
    
    /** The {@link Player}'s number in the game. */
    protected int playerNumber;
    
    AbstractPlayer(int uniqueNum){
        playerNumber = uniqueNum;
        hand = new Card[0];
        bookScore = 0;
    }
    
    private Card[] removeCards(int rank){
        int count = countCards(rank);
        Card[] result = new Card[count];
        Card[] newHand = new Card[hand.length-count];
        int j = 0;
        int k = 0;
        for (int i = 0; i < hand.length;i++) {
            if(hand[i].getRank() == rank){ // put all cards of rank into result array
                result[j] = hand[i];
                j++;
            }
            else{ // put all cards that are not that rank into new hand
                newHand[k] = hand[i];
                k++;
            }
        }
        hand = newHand; // update hand
        return result;
    }
    
    protected int countCards(int rank){
        int result = 0;
        for (Card card : hand) {
            if(card.getRank() == rank)
            result++;
        }
        return result;
    }

    @Override
    public abstract int decideRank();
    
    @Override
    public void gainCards(Card[] cards) {
        Card[] newHand = new Card[hand.length + cards.length];

        for (int i = 0; i < hand.length; i++) {
            newHand[i] = hand[i];
        }
        for (int i = 0; i < cards.length; i++) {
            newHand[hand.length + i] = cards[i];
        }
    
        hand = newHand;
    }

    @Override
    public Card[] requestCards(int rank) {
        Card[] result = new Card[countCards(rank)];
        int i = 0;
        for(Card card : hand){
            if(card.getRank() == rank){
                result[i] = card;
                i++;
            }
        }
        return removeCards(rank);
    }

    @Override
    public void checkBooks() {
        for(Card card : hand){
            if(countCards(card.getRank()) == 4){
                removeCards(card.getRank());
                bookScore++;
            }
        }
    }

    @Override
    public int getNumCards() {
        return hand.length;
    }

    public int getBookScore() {
        return bookScore;
    }

}