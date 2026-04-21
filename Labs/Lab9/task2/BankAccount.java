public abstract class BankAccount {
    private String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        if (balance > 0) {
            this.balance = balance;
        }
    }

    public abstract double calculateInterest();

    public void deposit (double amount) {
        if (amount < 1) {
            System.out.println("Invalid deposit amount: " + amount);
        }

        this.balance += balance;
    }
}