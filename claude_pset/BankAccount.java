// Problem 2 — Constructors + Static Members + Encapsulation
// ⏱ 60 min
// Model a BankAccount class:

// Private fields: String owner, double balance, String accountNumber
// Static field totalAccounts (increments each time a new account is created)
// Static method getTotalAccounts()
// 3 overloaded constructors: no-arg (defaults), owner only, owner + initial balance
// Getters/setters with validation (e.g., balance can't go negative on withdrawal)
// deposit(), withdraw(), printStatement() methods
// main() creating 3 accounts, demonstrating static counter and encapsulation

// Concepts hit: constructor overloading, static members, encapsulation, data hiding
import java.util.List;
import java.util.ArrayList;

public class BankAccount {
    private String owner;
    private double balance;
    private String accountNumber;
    private List<String> transactionHistory;

    private static int totalAccounts = 0;

    public static int getTotalAccounts () {
        return totalAccounts;
    }

    public BankAccount () {
        this("Unknown", 0.0);
    };

    public BankAccount (String owner) {
        this(owner, 0.0);
    }

    public BankAccount (String owner, double balance) {
        this.owner = owner;
        this.transactionHistory = new ArrayList<>();
        if (balance > 0) this.deposit(balance);
        else this.balance = 0;
        this.accountNumber = "ZBC-" + BankAccount.totalAccounts;
        BankAccount.totalAccounts ++;
    }

    public double getBalance () {
        return this.balance;
    }

    public String getOwner () {
        return this.owner;
    }

    public void setOwner (String newOwner) {
        if (newOwner.isBlank()) throw new IllegalArgumentException("New Owner can't be empty");
        this.owner = newOwner;
    }

    public void deposit (double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid Deposit amount");
        }
        this.balance += amount;
        this.transactionHistory.add("Deposited: " +  amount + " New Balance: " + this.balance);
    }

    public void withdraw (double amount) {
        if (amount < 0 || this.balance - amount < 0) {
            throw new IllegalArgumentException("Invalid Withdraw amount");
        }
        this.balance -= amount;
        this.transactionHistory.add("Withdrawn: " + amount + " New Balance: " + this.balance );
    }

    public void printStatements () {
        System.out.println("Account No: " + this.accountNumber + " | Owner " + owner);
        for (String statement : this.transactionHistory) {
            System.out.println(statement);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BankAccount fahad = new BankAccount("fahad", 19.0);
        BankAccount sarmad = new BankAccount("Sarmad", 100.0);
        BankAccount haris = new BankAccount("Haris", 105.0);

        fahad.deposit(100);
        haris.withdraw(50);
        sarmad.deposit(10);
        fahad.withdraw(60);
        haris.deposit(60);
        fahad.printStatements();
        haris.printStatements();
        sarmad.withdraw(10);
        sarmad.printStatements();

        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}