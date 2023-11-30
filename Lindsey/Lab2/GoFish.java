import java.util.ArrayList;
import java.util.List;

/**
 * The GoFish class implements the game Go Fish.
 * 
 * @author CS Professors
 */
public class GoFish {
    /** The {@link Player}s in the game. */
    private List<Player> players;

    /** The {@link Deck} of {@link card}s. */
    private Deck deck;

    /** The number of {@link Card}s each {@link Player} should start with. */
    private static final int NUM_STARTING_CARDS = 5;

    /**
     * Creates a new GoFish game.
     * 
     * @param playerArgs The command line arguments of desired {@link Player} types (random or user)
     */
    public GoFish(String[] playerArgs) {
        // validate the user input
        this.validateUserInput(playerArgs);
        
        // create the instance variables
        this.players = new ArrayList<Player>();
        this.deck = new Deck();

        // populate the players based on the user input
        for (int i = 0; i < playerArgs.length; i++) {
            Player player = null;
            if ("random".equals(playerArgs[i].toLowerCase())) {
                player = new RandomPlayer(i + 1);
            } else if ("user".equals(playerArgs[i].toLowerCase())) {
                player = new UserPlayer(i + 1);
            }
            this.players.add(player);

            // give the player some cards
            player.gainCards(this.deck.drawCards(NUM_STARTING_CARDS));
        }
    }

    /**
     * Validates the user's command line arguments.  Prints a usage message and gracefully quits
     * if the inputs were invalid.
     * 
     * @param args The command line arguments
     */
    private void validateUserInput(String[] args) {
        // make sure the user gave 2 inputs for 2 players
        if (args.length != 2) {
            System.out.println("Please input two player types as command line arguments.");
            System.exit(-1);
        }

        // make sure bother player types are valid
        for (int i = 0; i < args.length; i++) {
            if (!"random".equals(args[i].toLowerCase()) &&
                    !"user".equals(args[i].toLowerCase())) {
                System.out.println("Valid players are Random and User.  Please try again.");
                System.exit(-1);
            }
        }
    }

    /**
     * Plays the game until we run out of cards.
     */
    public void play() {
        // alternate turns between the players
        int turn = 0;
        boolean turnDone;
        
        // continue until we run out of cards in the deck
        while (this.deck.getNumCards() > 0) {
            // get the player and opponent
            Player player = this.players.get(turn);
            Player opponent = this.players.get(1 - turn);

            turnDone = false;
            while (!turnDone && this.deck.getNumCards() > 0) {
                // make a request from the player to the opponent
                int rank = player.decideRank();
                Card[] cards = opponent.requestCards(rank);

                System.out.println("Player " + (turn + 1) + " requested " + rank + 
                                   " and received " + cards.length + " cards");
                
                // did the opponent hand over any cards?
                if (cards.length == 0) {
                    // draw a card for the player
                    cards = this.deck.drawCards(1);
                    turnDone = true;
                }

                // give the cards to the player
                player.gainCards(cards);
                
                // check if the player scored a book
                player.checkBooks();

                // make sure the opponent didn't run out of cards
                if (opponent.getNumCards() == 0 && this.deck.getNumCards() > 0) {
                    opponent.gainCards(this.deck.drawCards(1));
                }

                // make sure the player didn't run out of cards
                if (player.getNumCards() == 0 && this.deck.getNumCards() > 0) {
                    player.gainCards(this.deck.drawCards(1));
                }
            }

            // now it is the opponent's turn
            turn = 1 - turn;
        }

        // determine the winner
        int player1Score = this.players.get(0).getBookScore();
        int player2Score = this.players.get(1).getBookScore();

        if (player1Score == player2Score) {
            System.out.println("Both players tied with a score of " + player1Score);
        } else if (player1Score > player2Score) {
            System.out.println("Player 1 won with a score of " + player1Score + " to " + player2Score);
        } else {
            System.out.println("Player 2 won with a score of " + player2Score + " to " + player1Score);
        }
    }

    /**
     * The program that runs the GoFish game.
     * 
     * @param args The command line arguments (the types of two players)
     */
    public static void main(String args[]) {
        // create the game
        GoFish game = new GoFish(args);

        // play the game
        game.play();
    }
}
