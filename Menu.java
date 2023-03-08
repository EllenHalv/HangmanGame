import java.util.Scanner;

public class Menu {
    private int choice;
    WordList wordList = new WordList();
    Game game = new Game(wordList);

    // metod för menu som ligger i en while-loop
    public void showMenu() {
        boolean showMenu = true;
        Scanner scanner = new Scanner(System.in);

        while (showMenu == true) {

            System.out.println("Välkommen till Hangman-menyn!");
            System.out.println("\nVälj ett alternativ (1-4): ");
            System.out.println("1. Starta spelet");
            System.out.println("2. Lägg till ett ord i listan");
            System.out.println("3. Ta bort ett ord från listan");
            System.out.println("4. Avsluta spelet");
            System.out.println("5. Visa alla ord i listan");
            System.out.println(">>");

            choice = scanner.nextInt();
            checkMenuChoice();
        }
    }
    //hanterar användarens meny-val
    private void checkMenuChoice() {
            switch (choice) {
                case 1 -> game.startGame();
                case 2 -> wordList.addWord();
                case 3 -> wordList.removeWord();
                case 4 -> game.endGame();
                case 5 -> wordList.showWordList();
                default -> System.out.println("Ogiltigt val: " + choice + ". Försök igen.");
            }
    }
}
