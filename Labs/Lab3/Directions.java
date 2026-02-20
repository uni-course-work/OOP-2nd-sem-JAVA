import java.util.Scanner;

public class Directions {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Destination: ");
    String Destination = scanner.next().trim().toLowerCase();
    String Directions = "You are Lost";
    if ("building1".equals(Destination)) {
      Directions = "MOVE STRAIGHT";
    } else if ("building2".equals(Destination)) {
      Directions = "MOVE RIGHT";
    }
    System.out.println(Directions);
  }
}