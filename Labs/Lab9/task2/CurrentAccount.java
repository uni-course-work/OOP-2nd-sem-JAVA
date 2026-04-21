public class CurrentAccount extends BankAccount {
    private double interestRate;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
        this.interestRate = 0.2;
    }

    @Override
    public double calculateInterest() {
        return this.balance * this.interestRate;
    }
}