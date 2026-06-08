public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException (double balance, double amount) {
        super("Insufficient balance: " + balance + " for " + amount + " withdrawl");
    }
}
