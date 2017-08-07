//Contains all game logic


public class Game {
    // All Games
    public static final int MAX_MISSES = 7;
    private String mAnswer;
    private String mHits;
    private String mMisses;

    // This instaniation of Game
    public Game(String answer) {
        mAnswer = answer;
        mHits = " ";
        mMisses = " ";
    }

    // this method validates whether correct data type is entered by user
    public boolean applyGuess(String letters) {
        if (letters.length() == 0) {
            throw new IllegalArgumentException("There aro no letters!");
        }
    // if correct data type is entered, then applyGuess method that accepts char is run
        return applyGuess(letters.charAt(0));
    }

    //stores sHit as true or adds a count on mMisses
    public boolean applyGuess(char letter) {
        letter = validateGuess(letter);
        boolean isHit = mAnswer.indexOf(letter) >= 0;
        if (isHit) {
            mHits += letter;
        } else {
            mMisses += letter;
        }
        return isHit;
    }

    private char validateGuess(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("A letter is required");
        }
        if (mHits.indexOf(letter) >= 0 || mMisses.indexOf(letter) >= 0) {
            throw new IllegalArgumentException(letter + " is already been guessed");
        }
        return letter;
    }

    public String getCurrentProgress() {
        String progress = " ";
        for (char letter : mAnswer.toCharArray()) {
            char display = '-';

            if (mHits.indexOf(letter) >= 0) {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public int getRemainingTries() {
        return MAX_MISSES - mMisses.length();
    }

    public String getAnswer() {
        return mAnswer;
    }

    public boolean isSolved() {
        return getCurrentProgress().indexOf('-') == -1;
    }
}