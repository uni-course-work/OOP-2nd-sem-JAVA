import java.util.Scanner;

public class StudentsList {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the Number of students: ");
    int N = scanner.nextInt();
    scanner.nextLine();
    String[] students = new String[N];
    for (int i = 0; i < N; i++) {
      System.out.print("Enter student no " + (i + 1) + " : ");
      students[i] = scanner.nextLine();
    }
    for (int i = 0; i < N; i++) {
      System.out.println((i + 1) + " : " + students[i]);
    }
    scanner.close();
  }
}