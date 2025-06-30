 import java.util.ArrayList;
import java.util.List;

/**
 * BankAccount class handles basic banking operations
 * like deposit, withdrawal, balance check, and transaction history.
 */
public class BankAccount {
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    // Constructor to initialize account
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created for: " + accountHolder);
    }

    // Deposit money into account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("✅ ₹" + amount + " deposited successfully.");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Withdraw money from account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }

    // Display current balance
    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    // Show transaction history
    public void viewTransactionHistory() {
        System.out.println("\n📋 Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }
    }
}
