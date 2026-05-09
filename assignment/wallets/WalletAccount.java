public class WalletAccount {
    protected double balance;
    public WalletAccount () {
        this.balance = 0;
    }
    public void deposit (double amount) throws IllegalArgumentException{
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Invalid deposit amount: " + amount);
        }
        for (int i = 1; i <= amount; i += 10) {
            if (amount - i < 10) {
                System.out.println("Deposting: " + amount);
                this.balance += amount;
                System.out.println("Dopisit Complete");
                System.out.println("Total Balance: " + this.balance);
            } else {
                System.out.println("Dopisiting: 10");
                this.balance += 10;
                System.out.println("Total Balance: " + this.balance);
            }
        }
    }
}
