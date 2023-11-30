import java.util.Scanner;

public class UserPlayer extends AbstractPlayer{

    /** The {@link Scanner} to use to interact with the user. */
    private Scanner scanner;

    UserPlayer(int playerNumber){
        super(playerNumber);
        scanner = new Scanner(System.in);
    }

    @Override
    public int decideRank() {
        System.out.println("Here are your current cards:");
        for (Card card : hand) {
            System.out.print(card.getRank() + " of " + card.getSuit() + "s.\n");
        }

        String userIn;
        int selectedRank = -1;

        while (true) {
            System.out.print("Which card would you like to request (Please select a rank that you have in your deck): ");
            userIn = scanner.nextLine();

            try {
                selectedRank = Integer.parseInt(userIn);
                
                if (countCards(selectedRank) > 0) {
                    break; 
                } else {
                    System.out.println("You don't have any cards of rank " + selectedRank + ". Please select a valid rank.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return selectedRank;
    }

    // public static void main(String[] args) {
    //     UserPlayer player = new UserPlayer(2);
    //     Card[] cards = new Card[] {
    //         new Card(Card.Suit.Spade, 2),
    //         new Card(Card.Suit.Diamond, 4),
    //         new Card(Card.Suit.Spade, 5),
    //         new Card(Card.Suit.Club, 7),
    //     };
    //     player.gainCards(cards);
    //     int num = player.decideRank();
    //     System.out.println("Player has chosen rank: " + num);

    // }

}