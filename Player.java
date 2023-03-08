public class Player {
    private String name;
    private int guesses;
    private int points;

    public Player(String name, int guesses, int points) {
        this.name = name;
        this.guesses = guesses;
        this.points = points;
    }
    public String getName() {
        String firstLetter = name.substring(0, 1).toUpperCase();
        String restOfLetters = name.substring(1);
        String capName = firstLetter + restOfLetters;
        name = capName;
        return name;
    }
    public int getGuesses() {
        return guesses;
    }
    //returnera antalet gissningar spelaren har gjort
    public int getPoints() {
        return points;
    }
    //returnera antalet rätt gissningar spelaren har gjort
    public void increaseGuesses() {
        guesses++;
    }
    //öka antalet gissningar med 1
    public void increasePoints() {
        points++;
    }
    // Returnera en sträng med spelarens namn, antal gissningar och antal rätt gissningar
    public void showStandings() {
        System.out.println("\n" + getName() + " har gjort " + getGuesses() + " gissningar och har " + getPoints() + " rätt gissningar");
    }

}
