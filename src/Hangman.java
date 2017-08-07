public class Hangman {
    public static void main(String[] args) {
        Game game = new Game("Hired");
        //Instance of game is passed into prompter
        Prompter prompter = new Prompter(game);
        prompter.play();
    }
}