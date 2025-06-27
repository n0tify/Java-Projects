import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";

    // Method to write a note into the file
    public static void writeNote(String note) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // Append mode
            writer.write(note + System.lineSeparator());
            System.out.println("✅ Note saved successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error writing the note: " + e.getMessage());
        }
    }

    // Method to read all notes from the file
    public static void readNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n📄 Your Notes:");
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ No notes found. Please add some notes first.");
        } catch (IOException e) {
            System.out.println("❌ Error reading the notes: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== 📒 Notes App ====");
            System.out.println("1. Add a Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("🖊️ Enter your note: ");
                    String note = scanner.nextLine();
                    writeNote(note);
                    break;

                case 2:
                    readNotes();
                    break;

                case 3:
                    System.out.println("👋 Exiting Notes App. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }
}
