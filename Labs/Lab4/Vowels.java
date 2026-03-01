import java.util.Scanner;

public class Vowels {
  public static void main(String[] args) {
    String text = "";
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter END on a new line to analyze vowels in text");
    System.out.println("Put Text");
    while(true) {
      System.out.print("> ");
      String temp = scanner.nextLine().trim();
      if (temp.equals("END")) break;
      text = text.concat(temp + '\n');
    };
    scanner.close();
    int textLength = text.length();
    System.out.println("========= VOWELS =========");
    for (int i = 0; i < textLength; i++) {
      char c = Character.toLowerCase(text.charAt(i));
      if ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        System.out.print(c + " ");
      }
    }
    System.out.println();
  }
}
