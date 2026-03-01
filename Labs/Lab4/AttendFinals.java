import java.util.Scanner;

public class AttendFinals {
  public static void main(String[] args) {
    final double TOTAL_SESSIONAL_MARKS = 25.0;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your attendance percentage i.e 78.59: ");
    double percentage = scanner.nextDouble();
    System.out.print("Enter your obtained sessional marks: ");
    int sessionalMarks = scanner.nextInt();
    if (percentage > 75.0 && (sessionalMarks / TOTAL_SESSIONAL_MARKS * 100) > 70.0) {
      System.out.println("You are eligible to appear in final exams");
    } else {
      System.out.println("You are not eligible to appear in final exams");
    }
    scanner.close();
  }
}
