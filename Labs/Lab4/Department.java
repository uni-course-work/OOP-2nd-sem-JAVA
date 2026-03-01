import java.util.Scanner;

public class Department {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Type -1 to exit");
    int strength = 0;
    while (true) {
      System.out.print("Enter roll number: ");
      if (scanner.nextInt() == -1) break;
      scanner.nextLine();
      strength ++;
    }
    scanner.close();
    System.out.println("Total Students: " + strength);
  }
}
