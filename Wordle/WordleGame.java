import java.util.*;

public class WordleGame {
    private static final String[] WORDS = {"apple", "banana", "carrot", "donut", "elephant", "fruits", "grapes", "happy", "igloo", "jungle"};
    private static final int MAX_ATTEMPTS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretWord = generateSecretWord();
        int attempts = 0;

        System.out.println("Welcome to Wordle! Guess the 5-letter word.");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();

            if (guess.length() != 5) {
                System.out.println("Invalid guess! Please enter a 5-letter word.");
                continue;
            }

            attempts++;

            if (guess.equals(secretWord)) {
                System.out.println("Congratulations! You guessed the word '" + secretWord + "' correctly in " + attempts + " attempts.");
                return;
            }

            String hint = generateHint(guess, secretWord);
            System.out.println("Incorrect guess! Hint: " + hint);
        }

        System.out.println("Sorry, you're out of attempts. The secret word was '" + secretWord + "'. Better luck next time!");
    }

    private static String generateSecretWord() {
        return WORDS[new Random().nextInt(WORDS.length)];
    }

    private static String generateHint(String guess, String secretWord) {
        StringBuilder hint = new StringBuilder();

        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char secretChar = secretWord.charAt(i);

            hint.append(guessChar == secretChar ? guessChar : (secretWord.contains(String.valueOf(guessChar)) ? "+" : "-"));
        }

        return hint.toString();
    }
}
