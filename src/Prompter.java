import java.util.Scanner;

public class Prompter {
    private Game mGame;

    public Prompter(Game game) { //constructor takes the game logic object
        mGame = game;
    }

    public void play() {
        while (mGame.getRemainingTries() > 0 && !mGame.isSolved()) {
            displayProgress();
            promptForGuess();
        }
        if (mGame.isSolved()) {
            System.out.printf("You won the game with %s tries remaining", mGame.getRemainingTries());
        } else {
            System.out.printf("Try again! You should have guessed %s", mGame.getAnswer());
        }
    }

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        char guess;
        //both booleans set to false at the beginning of each game
        boolean isHit = false;
        boolean isValidGuess = false;

        while (!isValidGuess) {
            System.out.println("Enter a letter: ");
            String guessAsString = scanner.nextLine();
            try {
                isHit = mGame.applyGuess(guessAsString);
                isValidGuess = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s. Please try again. \n", iae.getMessage());
            }
        }
        return isHit;
    }

    public void displayProgress() {
        System.out.printf("You have %s more tries : %s\n",
                mGame.getRemainingTries(),
                mGame.getCurrentProgress());
    }
}