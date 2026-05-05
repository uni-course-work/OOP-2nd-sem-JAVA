package practice.assignment.wallets;

public class WalletAccount {
    private double balance;
    
    public void deposit (double amount) {
        if (amount <= 0.0) {
            throw IllegalArgumentException("Invalid deposit amount: " + amount);
        }

        for (int i = 1; i <= amount; i ++) {
            
        }
    }


}
