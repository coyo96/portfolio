import java.util.*;

public class WordleGame {
    private static final int MAX_ATTEMPTS = 6;
    private static final int WORD_LENGTH = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretWord = generateSecretWord();
        int attempts = 0;
        Set<Character> correctlyGuessed = new HashSet<>();

        System.out.println("Welcome to Wordle! Guess the " + WORD_LENGTH + "-letter word.");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() != WORD_LENGTH) {
                System.out.println("Invalid guess! Please enter a " + WORD_LENGTH + "-letter word.");
                continue;
            }

            attempts++;

            Set<Character> correctlyPlaced = new HashSet<>();
            StringBuilder hint = new StringBuilder();

            for (int i = 0; i < guess.length(); i++) {
                char guessChar = guess.charAt(i);
                char secretChar = secretWord.charAt(i);

                if (guessChar == secretChar) {
                    hint.append(colorize(Character.toString(guessChar), ConsoleColor.GREEN));
                    correctlyGuessed.add(guessChar);
                    correctlyPlaced.add(guessChar);
                } else if (secretWord.contains(String.valueOf(guessChar)) && !correctlyPlaced.contains(guessChar)) {
                    hint.append(colorize(Character.toString(guessChar), ConsoleColor.YELLOW));
                } else {
                    hint.append(guessChar);
                }
            }

            System.out.println("Incorrect guess! Hint: " + hint.toString());
            System.out.println("Characters correctly guessed so far: " + correctlyGuessed);

            if (guess.equals(secretWord)) {
                System.out.println("Congratulations! You guessed the word '" + secretWord + "' correctly in " + attempts + " attempts.");
                return;
            }
        }

        System.out.println("Sorry, you're out of attempts. The secret word was '" + secretWord + "'. Better luck next time!");
    }

    private static String generateSecretWord() {
        String[] words = {"apple", "value", "bliss", "donut", "court", "bumpy", "noise", "happy", "honor", "frame", "joint", "delve"};
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index];
    }

    private static String colorize(String text, ConsoleColor color) {
        return color.getCode() + text + ConsoleColor.RESET.getCode();
    }
}

enum ConsoleColor {
    RESET("\u001B[0m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m");

    private final String code;

    ConsoleColor(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
