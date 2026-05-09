public class PremiumSavingsWallet extends SavingsWallet {
    public void applyGrowth(int totalMonths) {
        for (int month = 1; month <= totalMonths; month++) {
            
            if (month >= 12) {
                this.balance += this.balance * 0.05; 
            } 
            else if (month >= 6) {
                this.balance += this.balance * 0.035; 
            } else {
                this.balance += this.balance * 0.02;
            }
        }
    }
}
