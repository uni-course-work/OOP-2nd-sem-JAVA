public class PremiumBank extends OuterBank {
    private double creditLimit;

    public PremiumBank(double balance, String owner, String accountNumber, double creditLimit) {
        super(balance, owner, accountNumber);   
        this.creditLimit = creditLimit;
    }

    public void overdraft(double amount) {
        if (amount > balance + creditLimit) {
            throw new IllegalArgumentException("Exceeds credit limit");
        }
        balance -= amount;
        System.out.println("Overdraft of " + amount + " | Balance: " + balance);
    }
}
