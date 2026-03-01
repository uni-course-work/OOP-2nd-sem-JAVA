import java.util.Scanner;
public class EligibleCS {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("1. FSC Pre Medical");
    System.out.println("2. FA");
    System.out.println("3. FSC Pre Engineering");
    System.out.println("4. ICS");
    System.out.println("USAGE: Enter 1 for FSC Pre Medical");
    System.out.print("Choose your HSSC Group: ");
    int hsscGroup = scanner.nextInt();
    String message = switch(hsscGroup) {
      case 1 -> "Sorry!, you, as an FSC Pre Medical student, are not eligible to get enrolled in CS";
      case 2 -> "Sorry! you, as an FA student, are not eligible to get enrolled in CS";
      case 3 -> "Congratulations! you, as an FSC Pre Engineering student, are Eligible to get Enrolled in CS";
      case 4 -> "Congratulations! You, as an ICS student, are Eligible to get Enrolled in CS";
      default -> "Invalid Option";
    };
    scanner.close();
    System.out.println(message);
  }
} 