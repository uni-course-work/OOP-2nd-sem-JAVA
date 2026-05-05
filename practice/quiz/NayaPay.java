public class NayaPay implements Payable {
    private double amount;
    
    public NayaPay (double amount) {
        this.amount = amount;
    }
    public void pay(double amount) throws InvalidAmountException{
        if (amount <= 0 || amount >= 100_000) {
            throw new InvalidAmountException("Invalid Amount");
        }
        this.amount -= amount;
    }
}
