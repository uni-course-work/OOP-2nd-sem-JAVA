import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarksAnalysisSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> studentMarks = new ArrayList<>();
        System.out.println("=".repeat(40));
        System.out.println("Students Marks Analysis System");
        System.out.println("=".repeat(40) + '\n');
        System.out.print("Enter number of Students: ");
        int noOfStudents = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < noOfStudents; i++) {
            System.out.print("Enter Marks of Student No " + (i + 1) + ": ");
            int marks = scan.nextInt();
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid Marks! Reenter Marks: ");
                marks = scan.nextInt();  
            }
            studentMarks.add(marks);
            scan.nextLine();
        }

        int totalMarks = 0;
        int passedStudents = 0;
        int failedStudents = 0;

        for (int marks : studentMarks) {
            if (marks >= 50) {
                passedStudents ++;
            } else {
                failedStudents ++;
            }
            totalMarks += marks;
        }
        System.out.println('\n' + "=".repeat(40));
        System.out.println("Total Marks: \t\t\t| " + totalMarks);
        System.out.println("Average Marks: \t\t\t| " + String.format("%.2f", (double) totalMarks / noOfStudents));
        System.out.println("Number of passed students: \t| " + passedStudents);
        System.out.println("Number of failed students: \t| " + failedStudents);
        System.out.println("=".repeat(40));
    }
}
