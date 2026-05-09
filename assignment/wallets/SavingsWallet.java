public class SavingsWallet extends WalletAccount {
    public void withdraw (double amount) throws InsufficientFundsException {
        if (amount > this.balance) {
            throw new InsufficientFundsException("Insufficient balance to pay " + this.balance);
        }
        for (int i = 0; i < amount; i+= 10) {
            if (amount < 10) {
                System.out.println("Withdrawing: " + amount);
                this.balance -= amount;
            } else {
                System.out.println("Withdrawing: 10");
                this.balance -= 10;
            }
        }
        if (this.balance < 50) {
            System.out.println("Funds below 50");
        } 
    }
}
