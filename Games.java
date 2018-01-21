import java.util.Random;
import java.util.Scanner;

/**
 * 
 * Games.
 *
 * @author Jeffrey
 * @version 2017
 */

public class Games {
    /**
     * Magic number three.
     */
    public static final int THREE = 3;
    /**
     * Magic number four.
     */
    public static final int FOUR = 4;
    /**
     * Magic number five.
     */
    public static final int FIVE = 5;
    /**
     * Magic number hundred and one.
     */
    public static final int HUNDREDONE = 101;

    /**
     * Keeps track of score.
     */
    private int score;
    /**
     * Declares Scanner object.
     */
    private Scanner scan;
    /**
     * Declares Random object.
     */
    private Random rand;

    /**
     * 
     * Constructs an object of type Games.
     */
    public Games() {
        score = 0;
        scan = new Scanner(System.in);
        rand = new Random();

    }

    /**
     * Controls all the games in this method.
     */
    public void play() {
        
        // TODO Auto-generated method stub
        while (true) {
            System.out.println("Welcome to the Games program!");
            System.out.println("Make your choice (enter a number)");
            System.out.println("1. See your score");
            System.out.println("2. Guess a number");
            System.out.println("3. Play Rock, Paper, Scissors");
            System.out.println("4. Quit");
            System.out.print("> ");
            int a = scan.nextInt();

            switch (a) {
            case 1:
                System.out.println("Your score is " + score);
                break;

            case 2:
                guessaNumber();
                break;

            case THREE:
                rockPaperScissors();
                break;

            case FOUR:
                return;

            default:

                System.out.println("That's not a valid choice");

            }

        }

    }

    /**
     * Runs the guess a number game.
     */
    public void guessaNumber() {
        // TODO Auto-generated method stub
        System.out.println("I've picked a random number between 0 and 100");
        int c = rand.nextInt(HUNDREDONE);
        System.out.println("What is your guess..?");
        int d = scan.nextInt();
        int count = 1;

        while (c != d) {

            if (c > d) {
                System.out.println("You guessed too low");

            }
            if (c < d) {
                System.out.println("You guessed too high");
            }

            d = scan.nextInt();
            count++;
        }

        System.out.println("Great, you got it");

        if (count <= FIVE) {
            System.out.println("Awesome you got it " 
        + "within 5 tries, 5 points!!!");
            score = score + FIVE;

        }

    }

    /**
     * Runs the rock, paper, scissors game.
     */
    public void rockPaperScissors() {
        // zero is rock
        // one is paper
        // two is scissors

        System.out.println("I have picked one of ROCK, PAPER, AND SCISSORS " 
           + "\n" + "What do you choose");
        String userInput = scan.next();
        String input = userInput.trim().toLowerCase();
        int gen = rand.nextInt(THREE);

        while (true) {
            if (input.equals("rock")) {

                if (gen == 0) {

                    System.out.println("tie");

                } else if (gen == 1) {
                    System.out.println("Paper covers rock, you lose 3 points");
                    score = score - THREE;

                }

                if (gen == 2) {
                    System.out.println("Rock smashes scissors, "
                            + "you win 5 points");
                    score = score + FIVE;

                }

                return;
            }
            if (input.equals("paper")) {
                if (gen == 0) {
                    System.out.println("Paper covers rock, you win 5 points");
                    score = score + FIVE;

                } else if (gen == 1) {
                    System.out.println("tie");

                }

                if (gen == 2) {
                    System.out.println("Scissors cuts paper, "
                            + "you lose 3 points");
                    score = score - THREE;

                }
                return;
            }

            if (input.equals("scissors")) {

                if (gen == 0) {
                    System.out.println("Rock smashes scissors, "
                            + "you lose 3 points ");
                    score = score - THREE;

                } else if (gen == 1) {
                    System.out.println("Scissors cuts paper, you win 5 points");
                    score = score + FIVE;

                }

                if (gen == 2) {
                    System.out.println("tie");

                }

                return;
            }

            while (!(input.equals("rock") || input.equals("scissors") 
                    || input.equals("paper"))) {
                System.out.println("Enter valid input");
                input = scan.next();

            }

        }
    }

}
