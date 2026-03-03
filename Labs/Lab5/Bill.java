import java.util.ArrayList;
import java.util.Scanner;

public class Bill {
  public static void main(String[] args) {
    ArrayList<Integer> products = new ArrayList<Integer>();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter -1 price to exit");
    while (true) {
      System.out.print("Enter Price: ");
      int price = scanner.nextInt();
      products.add(price);
      scanner.nextLine();
      if (price == -1) break;
    }
    int total = 0;
    for (int price : products) {
      total += price;
    }
    System.out.println("Total Price: " + total);
  }    
}