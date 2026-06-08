// Problem 7 — Exception Handling
// ⏱ 60 min
// Extend Problem 2's BankAccount:

// Create custom exceptions: InsufficientFundsException, InvalidAmountException, AccountFrozenException
// withdraw() throws InsufficientFundsException if balance too low
// deposit() throws InvalidAmountException if amount ≤ 0
// Add a frozen flag — any operation on a frozen account throws AccountFrozenException
// In main(), write a transaction loop using try / catch / finally — finally always prints the current balance regardless of whether the operation succeeded

// Concepts hit: custom exception classes, throw, throws, try/catch/finally, multiple catch blocks, exception hierarchy

import java.util.List;
import java.util.ArrayList;

public class BankAccount {
    private String owner;
    private double balance;
    private String accountNumber;
    private boolean frozen;
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
        this.accountNumber = "ZBC-" + BankAccount.totalAccounts;
        this.transactionHistory = new ArrayList<>();
        if (balance > 0) this.deposit(balance);
        else this.balance = 0;
        BankAccount.totalAccounts ++;
    }

    public double getBalance () {
        if (frozen) throw new AccountFrozenException(accountNumber);
        return this.balance;
    }

    public String getOwner () {
        return this.owner;
    }

    public void freeze () {
        this.frozen = true;
    }

    public void unfreeze () {
        this.frozen = false;
    }
    public void setOwner (String newOwner) {
        if (newOwner.isBlank()) throw new IllegalArgumentException("New Owner can't be empty");
        this.owner = newOwner;
    }

    public void deposit (double amount) throws InvalidAmountException, AccountFrozenException {
        if (frozen) throw new AccountFrozenException(accountNumber);
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }
        this.balance += amount;
        this.transactionHistory.add("Deposited: " +  amount + " New Balance: " + this.balance);
        System.out.println("Deposited " + amount + " to: " + accountNumber);
    }

    public void withdraw (double amount) throws InsufficientFundsException, AccountFrozenException {
        if (frozen) throw new AccountFrozenException(accountNumber);

        if (amount <= 0 || this.balance - amount <= 0) {
            throw new InsufficientFundsException (balance, amount);
        }
        this.balance -= amount;
        this.transactionHistory.add("Withdrawn: " + amount + " New Balance: " + this.balance );
        System.out.println("Withdrawn " + amount + " from :" + accountNumber);
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

        BankAccount[] accounts = {haris,   fahad,   haris,  sarmad,   fahad,    fahad};
        String[]       actions  = {"DEP",  "DEP",   "WITH", "DEP",    "WITH",   "WITH"};
        double[]       amounts  = {-100,    100,     50,     100,      50,       1000};

        for (int i = 0; i < amounts.length; i++) {
            try {
                if (actions[i].equals("DEP"))  accounts[i].deposit(amounts[i]);
                else                           accounts[i].withdraw(amounts[i]);
            } catch (InsufficientFundsException e) {
                System.out.println("Insufficient: " + e.getMessage());
            } catch (InvalidAmountException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (AccountFrozenException e) {
                System.out.println("Frozen: " + e.getMessage());
            } finally {
                System.out.println("Balance: " + accounts[i].balance + "\n");
            }
        }
    }
}