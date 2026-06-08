public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException (double amount) {
        super("Invalid amount: " + amount);
    }
}
