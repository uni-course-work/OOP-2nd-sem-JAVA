public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount (String accountNumber, double balance) {
        super(accountNumber, balance);
        this.interestRate = 0.4;
    }

    @Override
    public double calculateInterest() {
        return this.balance * this.interestRate;
    }
}