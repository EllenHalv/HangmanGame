import java.util.ArrayList;
import java.util.Scanner;

public class Game {
        private WordList wordList;
        private Word word;
        private Player player;
        private ArrayList<Object> guessedObjects;

    public Game (WordList wordList) {
        this.wordList = wordList;
    }
    public void startGame() {
        System.out.println("[Skapa ny spelare]");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vad heter du?");
        String name = scanner.nextLine();
        player = new Player(name, 0, 0);

        Boolean keepPlaying = true;
        Boolean winner = false;

        while (keepPlaying) {
            guessedObjects = new ArrayList<>();
            System.out.println();
            System.out.println("Hej " + player.getName()+ "! Nu börjar vi spelet!");
            this.word = new Word(wordList.randomWord());
            System.out.println("Du ska gissa på ett ord som består av " + word.getWord().length() + " bokstäver.");
            while (!winner) {
                guess();
                System.out.println(word.getGuess());

                winner = winnerCheck();
            }
        }
    }
    private void guess() {
        //DELAS GÄRNA UPP I FLER METODER
        Scanner scanner = new Scanner(System.in);
        player.showStandings();
        System.out.println("Du har gissat bokstäverna: " + guessedObjects);
        System.out.println("\nGissa på en bokstav eller ett ord:");
        String guess = scanner.next();
        player.increaseGuesses();

        if (guess.length() == 1) {
            char letter = guess.charAt(0);

            if (guessedObjects.contains(letter)) {
                System.out.println("Du har redan gissat på bokstaven " + '"' + letter + '"' + ". Försök igen!");
                return;
            }
            guessedObjects.add(letter);

            if (!word.matchGuess(letter)) {
                System.out.println("Tyvärr, bokstaven " + letter + " finns inte i ordet.");
            } else {
                System.out.println("Bra gissat! Bokstaven " + letter + " finns i ordet.");
                word.displayLetter(letter);
                player.increasePoints();
            }
        }
        else {
            if (guessedObjects.contains(guess)) {
                System.out.println("Du har redan gissat på " + guess);
            }
            guessedObjects.add(guess);

            if (word.matchWord(guess)) {
                System.out.println("\nGrattis! Du gissade rätt!");
                System.out.println("Ordet var " + '"' + word.getWord() + '"');
                System.out.println("\nVill du spela igen? (J/N)");
                String svar = scanner.next();

                if (svar.equalsIgnoreCase("J")) {
                    startGame();
                } else {
                    endGame();
                }
            }
            else {
                System.out.println("Tyvärr, det var inte rätt ord. Försök igen!");
            }
        }
    }
    private boolean winnerCheck() {
       return word.hasWon();
    }
    public void endGame() {
        System.out.println("Avslutar programmet...");
        System.exit(0);
    }
}
