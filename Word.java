public class Word {

    private String word;
    private String guess;
    public Word(String word) {
        this.word = word;
        this.guess = "";
        for (int i = 0; i < word.length(); ++i) {
            guess += "-";
        }
    }
    //returnerar ordet
    public String getWord() {
        return word;
    }
    //returnerar det gissade ordet
    public String getGuess() {
        return guess;
    }
    //kollar om en given bokstav matchar någon i ordet
    public boolean matchGuess(char letter) {
        return word.contains(Character.toString(letter));
    }
    //kollar om ett givet ord matchar gissningen
    public boolean matchWord(String guess) { return word.contains(guess); }

    //ersätter alla matchande streck i ordet med en bokstav
    public String displayLetter(char letter) {
        String newGuess = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                newGuess += letter;
            } else {
                newGuess += guess.charAt(i);
            }
        }
        guess = newGuess;
        return guess;
    }

    //Kollar om det gissade ordet är som det man ska gissa på
    public boolean hasWon() {
        return guess.equals(word);
    }

}
