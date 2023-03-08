import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
class WordList {
    private String word;
    private ArrayList<String> wordList;

    public WordList() {
        wordList = new ArrayList<>();
        wordList.add("katt");
        wordList.add("banan");
        wordList.add("båt");
        wordList.add("apelsin");
        wordList.add("cykel");
        wordList.add("kaktus");
        wordList.add("vampyr");
        wordList.add("tofflor");
        wordList.add("aprilskämt");
    }
    //skriver ut listan
    public void showWordList() {
        System.out.println(wordList);
    }
    //lägger till ett ord i listan
    public void addWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in ett ord du vill lägga till: ");
        String word = scanner.nextLine().toLowerCase();
        wordList.add(word);
        System.out.println('"' + word + '"' + " har lagts till i listan.");
        showWordList();
    }
    //ber om ett ord från användaren och tar bort ordet
    public void removeWord() {
        showWordList();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in ett ord du vill radera: ");
        String deleteWord = scanner.nextLine();
        if (wordList.contains(deleteWord)) {
            wordList.remove(deleteWord);
            System.out.println("Ordet har raderats.");
        } else {
            System.out.println(deleteWord + " finns inte i listan.");
        }
    }
    //returnerar det valda ordet
    public String getWord() {
        return word;
    }
    //returnerar ett random ord från listan
    public String randomWord() {
        Random random = new Random();
        word = wordList.get(random.nextInt(wordList.size()));
        return word;
    }
}

