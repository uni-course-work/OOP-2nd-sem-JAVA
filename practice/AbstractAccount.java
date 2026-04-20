abstract class Account {
    protected int balance;
    public Account (int balance) {
        if (balance >= 0) {
            this.balance = balance;
        };
    }
    public abstract void deposit (int amount);
    public abstract void withdraw (int amount);
}

class BankAccount extends Account{
    public BankAccount(int balance) {
        super(balance);
    }
    @Override
    public void deposit (int amount) {
        if (amount < 1) {
            System.out.println("Transaction failed! due to invalid deposit amount : " + amount);
            return;
        }
        this.balance += amount;
        System.out.println("Transaction succesful! " + amount + " has been deposited");
        System.out.println("The remaining balance is: " + this.balance);
    }

    @Override
    public void withdraw (int amount) {
        if (this.balance < amount) {
            System.out.println("Transaction failed! due to insufficient balance");
            return;
        }
        this.balance -= amount;
        System.out.println("Transaction succesful! " + amount  +" has been withdrawn!");
        System.out.println("The remaining balance is: " + this.balance);
    }

    public void done () {
        System.out.println("It's done");
    }
}

public class AbstractAccount {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(100);
        acc.deposit(100);
        acc.withdraw(200);
        acc.withdraw(100);
    }
}