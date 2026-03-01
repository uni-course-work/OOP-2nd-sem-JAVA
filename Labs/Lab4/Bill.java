import java.util.Scanner;

public class Bill {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int total = 0;
    for (int i = 1; i <= 3; i++) {
      System.out.print("Enter Food Item no " + i + ": ");
      scanner.nextLine();
      System.out.print("Enter price of item no " + i + ": ");
      total += scanner.nextInt();
      scanner.nextLine();
    }
    if (total < 500) {
      System.out.println("Rs 50 will be added as DC");
      total += 50;
    }
    System.out.println("Your total bill is: " + total);
    scanner.close();
  }
}
