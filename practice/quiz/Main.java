import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CreditCard cr = new CreditCard(100);
        NayaPay np = new NayaPay(100);
        BankTransfer bt = new BankTransfer(100);
        System.out.println("Options\n1: CreditCard\n2: NayaPay\n3:BankTransfer");
        System.out.print("Choose Payment Method:");
        try {
            int option = scan.nextInt();
            scan.nextLine();
            System.out.print("Enter Amount: ");
            double amount = scan.nextDouble();
            scan.nextLine();
            if (option == 1) {
                cr.pay(amount);
            } else if (option == 2) {
                np.pay(amount);
            } else if (option == 3) {
                bt.pay(amount);
            }
        } catch (NumberFormatException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Transaction Session closed");
        }
    }
}
