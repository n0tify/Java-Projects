 import java.util.Scanner;

/**
 * BankApp class - Acts as the entry point for the Bank Account Simulation.
 * Handles user interaction and menu-driven operations.
 */
public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("👤 Enter Account Holder Name: ");
        String name = scanner.nextLine();

        BankAccount account = new BankAccount(name);

        while (true) {
            System.out.println("\n===== 🏦 Bank Menu =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number between 1-5.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();  // consume newline
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();  // consume newline
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.viewTransactionHistory();
                    break;
                case 5:
                    System.out.println("👋 Exiting... Thank you for using our Bank App!");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please select between 1 to 5.");
            }
        }
    }
}

