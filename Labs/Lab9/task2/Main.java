public class Main {
    public static void main(String[] args) {
        SavingsAccount savingAcc = new SavingsAccount("123", 100);
        CurrentAccount currentAcc = new CurrentAccount("234", 100);
        savingAcc.deposit(100);
        currentAcc.deposit(10);
        System.out.println("Interest of Saving Account: " + savingAcc.calculateInterest());
        System.out.println("Interest of Current Account: " + currentAcc.calculateInterest());
    }
}
