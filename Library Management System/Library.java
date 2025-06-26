import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("\nBooks Available:");
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                System.out.println(i + ". " + book.getTitle() + " by " + book.getAuthor() + " | Issued: " + book.isIssued());
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();

        // Sample books
        library.addBook(new Book("Java Programming", "James Gosling"));
        library.addBook(new Book("OOP Concepts", "Bjarne Stroustrup"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    library.displayBooks();
                    System.out.print("Enter the book index to issue: ");
                    int issueIndex = scanner.nextInt();
                    if (issueIndex >= 0 && issueIndex < library.books.size()) {
                        library.books.get(issueIndex).issueBook();
                    } else {
                        System.out.println("Invalid book index.");
                    }
                    break;

                case 3:
                    library.displayBooks();
                    System.out.print("Enter the book index to return: ");
                    int returnIndex = scanner.nextInt();
                    if (returnIndex >= 0 && returnIndex < library.books.size()) {
                        library.books.get(returnIndex).returnBook();
                    } else {
                        System.out.println("Invalid book index.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
