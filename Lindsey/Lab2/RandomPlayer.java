import java.util.Random;
public class RandomPlayer extends AbstractPlayer{

    RandomPlayer(int playerNumber){
        super(playerNumber);
    }

    @Override
    public int decideRank() {
        Random random = new Random();
        int randomIndex = random.nextInt(super.getNumCards());
        return super.hand[randomIndex].getRank();
    }

    // ---------------------- FOR TESTING ----------------------
    // public static void main(String args[]){
    //     RandomPlayer player = new RandomPlayer(1);
    //     System.out.println(player.getBookScore());
    //     System.out.println("Player has " + player.getNumCards() + " cards.");
    //     Card[] cards = new Card[] {
    //         new Card(Card.Suit.Spade, 2),
    //         new Card(Card.Suit.Diamond, 4),
    //         new Card(Card.Suit.Spade, 5),
    //         new Card(Card.Suit.Club, 7),
    //     };
    //     player.gainCards(cards);
    //     System.out.println("Player has " + player.getNumCards() + " cards.");
    //     System.out.println("Cards in players hand:");
    //     for(Card card : player.hand){
    //         System.out.println(card.getRank() + " of " + card.getSuit() + "s");
    //     }

    // }

}