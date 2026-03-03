import java.util.ArrayList;
import java.util.Collection;

public class SportsGala {
  public static void main(String[] args) {
    ArrayList <String> sports = new ArrayList<String>();
    sports.add("Ludo");
    sports.add("Chess");
    sports.add("Table Tennis");
    sports.add("Spoon Race");
    System.out.println("All Sports: ");
    for (String game: sports) {
      System.out.print(game + " ");
    }
    System.out.println();
    sports.remove("Spoon Race"); // Remove Spoon Race
    sports.add("Cricket");
    System.out.print("All Sports (Updated): ");
    for (String game: sports) {
      System.out.print(game + " ");
    }
    System.out.println();
    System.out.println("Sports Gala have Chess ? " + sports.contains("Chess"));
  }    
}