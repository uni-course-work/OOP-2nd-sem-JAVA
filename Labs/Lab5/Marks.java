import java.util.ArrayList;
import java.util.Scanner;

public class Marks {
  public static void main(String[] args) {
    int N = 50;
    ArrayList<Integer> studentMarks = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    System.out.println("ENTER MARKS");
    int totalMarks = 0;
    int max = 0, min = 100;
    double averageMarks = 0;
    for (int i = 0; i < N; i++) {
      System.out.print("Student No " + (i + 1) + ": ");
      int mark = scanner.nextInt();
      if (mark > max) max = mark;
      if (mark < min) min = mark;
      studentMarks.add(mark);
      totalMarks += mark;
      scanner.nextLine();
      System.out.println();
    }
    averageMarks = totalMarks / (double) N;
    System.out.println("AVERAGE MARKS: " + averageMarks);
    System.out.println("HEIGHEST MARKS: " + max);
    System.out.println("LOWEST MARKS: " + min);
    System.out.println("SCORED ABOVE AVERAGE");
    for (int i = 0; i < N; i++) {
      int marks = studentMarks.get(i);
      if (marks > averageMarks) {
        System.out.println("Student no: " + (i + 1) + " with " + (marks) + " marks");
      }
    }
    System.out.println("FAILED STUDENTS");
    for (int i = 0; i < N; i++) {
      int marks = studentMarks.get(i);
      if (marks < 50) {
        System.out.println("Student no: " + (i + 1) + " with " + (marks) + " marks");
      }
    }
    System.out.println("DISTINCTION STUDENTS");
    for (int i = 0; i < N; i++) {
      int marks = studentMarks.get(i);
      if (marks > 85.0) {
        System.out.println("Student no: " + (i + 1) + " with " + (marks) + " marks");
      }
    }
    scanner.close();
  }
}