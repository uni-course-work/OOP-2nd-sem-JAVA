import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PremiumSavingsWallet acc = new PremiumSavingsWallet();
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Apply Growth");
            System.out.println("Any Other command to exit");
        while (true) {
            try {
                System.out.print("Choose Command: ");
                String command = scan.nextLine();
                if ("1".equals(command.trim())) {
                    System.out.print("Deposit amount: ");
                    double amount = scan.nextDouble();
                    scan.nextLine();
                    acc.deposit(amount);
                } else if ("2".equals(command.trim())) {
                    System.out.print("Withdraw amount: ");
                    double amount = scan.nextDouble();
                    scan.nextLine();
                    acc.withdraw(amount);
                } else if ("3".equals(command.trim())) {
                    System.out.println("Applying Growth");
                    acc.applyGrowth(16);
                } else {
                    break;
                }         
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
