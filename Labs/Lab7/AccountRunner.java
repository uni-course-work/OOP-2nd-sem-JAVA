class Account {
  int balance;

  public Account (int intialBalance) {
    if (intialBalance > 0) {
      balance = intialBalance;
      showBalance();
    }
  }
  public Account(){
    showBalance();
  }
  void showBalance() {
      System.out.println("Current Balance: " + balance);
  }
  int widthdraw (int amount) {
    if (amount > balance) {
        System.out.println("Balance " + balance + " is insufficient for withdrawing " + amount);
        return -1;
    } 
    balance -= amount;
    System.out.println("You Withdrawn: " + amount);
    showBalance();
    return balance;
  }
  
  int deposit (int amount) {
    if (amount < 1) {
      System.out.println("Invalid depoist amount: " + amount);
      return -1;
    }
    balance += amount;
    System.out.println("You deposited: " + amount);
    showBalance();
    return balance;
  }
}
public class AccountRunner {
  public static void main(String[] args) {
    Account cr = new Account(50000);
    cr.deposit(5000);
    cr.widthdraw(2000);
    Account gr = new Account(cr.balance);
    gr.balance = 70000;
    gr.showBalance();
  }
}
