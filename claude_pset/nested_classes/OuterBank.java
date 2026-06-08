public class OuterBank {
    protected double balance;
    protected String owner;
    protected String accountNumber;
    public OuterBank (double balance, String owner, String acccountNumber) {
        this.balance = balance;
        this.owner = owner;
        this.accountNumber = acccountNumber;
    } 

    static class LoanPolicy {
        private final double interestRate;
        private final double maxAmount;
        public LoanPolicy (double interestRate, double maxAmount) {
            if (interestRate < 0 || maxAmount < 0) {
                throw new IllegalArgumentException("Invalid interest rates or maxAmount: " + interestRate + " " + maxAmount);
            }
            this.interestRate = interestRate;
            this.maxAmount = maxAmount;
        }

        public double getInterestRate () {
            return interestRate;
        }

        public double getMaxAmount () {
            return this.maxAmount;
        }
    }

    class Transaction {
        private double amount;
        private String action;

        public Transaction (double amount, String action) {
            this.amount = amount;
            this.action = action;
        }

        public void execute () {
            if (action.equals("deposit") && amount > 0) {
                balance += amount;
            } else if (action.equals("withdraw") && amount > 0 && balance - amount > 0) {
                balance -= amount;
            }
        }

        public void print() {
        System.out.println("Account: " + accountNumber +
                           " | Owner: " + owner +
                           " | " + action + ": " + amount +
                           " | Balance: " + balance);
        }
    }
}