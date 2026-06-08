public class Main {
    public static void main(String[] args) {

        OuterBank.LoanPolicy policy = new OuterBank.LoanPolicy(5.5, 50000);
        System.out.println("Interest Rate: " + policy.getInterestRate());
        System.out.println("Max Loan: " + policy.getMaxAmount());

        OuterBank account = new OuterBank(1000.0, "Fahad", "ACC-001");
        OuterBank.Transaction t1 = account.new Transaction(500.0, "DEPOSIT");
        t1.execute();
        t1.print();

        OuterBank.Transaction t2 = account.new Transaction(200.0, "WITHDRAW");
        t2.execute();
        t2.print();

        PremiumBank premium = new PremiumBank(500.0, "Sarmad", "ACC-002", 1000.0);
        premium.overdraft(1200.0);
    }
}