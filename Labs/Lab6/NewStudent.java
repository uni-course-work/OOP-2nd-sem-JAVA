// Define class student with following attributes
// a. Name
// b. Number of subjects
// c. Marks (integer type array carrying marks of all subjects)
// Also define a member function takeMarks() in which you will ask the user to enter marks. Additionally define a
// display() function which will display all the details including name, number of subjects and marks.
// in main method, create one object of the class Student and call the two methods which you defined above
import java.util.Arrays;
import java.util.Scanner;
public class NewStudent {
  String name;
  int numberOfSubjects;
  int[] marks;

  public NewStudent (String name, int numberOfSubjects) {
    this.name = name;
    this.numberOfSubjects = numberOfSubjects;
    this.marks = new int[numberOfSubjects];
  }

  public void takeMarks() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter " + name + " marks: ");
    for (int i = 0; i < numberOfSubjects; i ++) {
      this.marks[i] = scanner.nextInt();
    }
    scanner.close();
  }

  public void display() {
    System.out.println("Name:\t\t\t" + name);
    System.out.println("Number of Subjects:\t" + numberOfSubjects);
    System.out.println("Marks:\t\t\t" + Arrays.toString(marks));
  }
  public static void main(String[] args) {
    NewStudent haris = new NewStudent("Haris Baig", 7);
    haris.takeMarks();
    haris.display();
  }
}
