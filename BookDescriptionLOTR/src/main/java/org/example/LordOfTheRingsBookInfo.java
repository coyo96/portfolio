import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String publicationDate;
    private int numPages;
    private String description;

    public Book(String publicationDate, int numPages, String description) {
        this.publicationDate = publicationDate;
        this.numPages = numPages;
        this.description = description;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public int getNumPages() {
        return numPages;
    }

    public String getDescription() {
        return description;
    }
}

public class LordOfTheRingsBookInfo {
    public static void main(String[] args) {
        // Create a map to store book information
        Map<String, Book> bookInfo = new HashMap<>();
        bookInfo.put("The Fellowship of the Ring", new Book("1954", 423, "Book 1 of the Lord of the Rings trilogy. Nine heroes bond together to begin their journey of destroying the One Ring."));
        bookInfo.put("The Two Towers", new Book("1954", 352, "Book 2 of the Lord of the Rings trilogy."));
        bookInfo.put("The Return of the King", new Book("1955", 416, "Book 3 of the Lord of the Rings trilogy. As the war rages on, the final confrontation before Good and Evil are presented to the future of Middle Earth."));
        bookInfo.put("The Silmarillion", new Book("1977", 365, "An epic 5-part history of Tolkien's world Arda. "));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(); // Add a line break for spacing
            System.out.println(); // Add a line break for spacing

            System.out.println("Lord of the Rings Book Selection:");
            System.out.println("1. The Fellowship of the Ring");
            System.out.println("2. The Two Towers");
            System.out.println("3. The Return of the King");
            System.out.println("4. The Silmarillion");
            System.out.println("0. Exit");
            System.out.print("Enter the number of the book you'd like to learn more about (or 0 to exit): ");
            int selection = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (selection == 0) {
                break; // Exit the program
            }

            System.out.println(); // Line break for spacing

            // Display book information based on user selection
            switch (selection) {
                case 1:
                    displayBookInfo(bookInfo.get("The Fellowship of the Ring"), "The Fellowship of the Ring");
                    break;
                case 2:
                    displayBookInfo(bookInfo.get("The Two Towers"), "The Two Towers");
                    break;
                case 3:
                    displayBookInfo(bookInfo.get("The Return of the King"), "The Return of the King");
                    break;
                case 4:
                    displayBookInfo(bookInfo.get("The Silmarillion"), "The Silmarillion");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }

            System.out.println("\n-----------------------------------");
        }

        System.out.println("Exiting the program. Goodbye!");
    }

    public static void displayBookInfo(Book book, String title) {
        System.out.println("Title: " + title);
        System.out.println("Publication Date: " + book.getPublicationDate());
        System.out.println("Number of Pages: " + book.getNumPages());
        System.out.println("Description: " + book.getDescription());

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter 'R' to return to the list of books: ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("R")) {
            System.out.println(); // Add a line break for spacing
        } else {
            System.out.println("Invalid input. Returning to the list of books.");
            System.out.println(); // Add a line break for spacing
        }
    }
}
