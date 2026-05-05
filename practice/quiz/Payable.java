public interface Payable {
    void pay(double amount) throws InvalidAmountException;
}
