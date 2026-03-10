// Define a class Student which has four attributes and two methods
// Name, Roll No, Attendance and Class name
//  submitAssignment() {print “Student has to submit assignment in given deadline
//  CanGiveExam(Attendance) (if attendance is more than 80 percent)
// Inside the main function, create two objects of the class, the second object’s value should be defined by user
// (using Scanner object)
// Finally call both methods for the two objects

public class Student {
  String name;
  int rollNo;
  double attendance;
  String className;

  public Student (String name, int rollNo, double attendance, String className) {
    this.name = name;
    this.rollNo = rollNo;
    this.attendance = attendance;
    this.className = className;
  }
  public void submitAssignment() {
    System.out.println("Student has to submit assignment in given deadline");
  }
  public String canTakeExam() {
    return attendance > 80.0 ? "YES" : "NO";
  }
  public void display () {
    System.out.println("Name:\t\t" + name);
    System.out.println("Roll No:\t" + rollNo);
    System.out.println("Attendance:\t" + attendance);
    System.out.println("Class Name:\t" + className);
  }
  public static void main(String[] args) {
    Student ali = new Student("Ali", 23, 85.0, "BS CS 2A");
    Student sarmad = new Student("Sarmad", 25, 79, "BS CS 2A");
    ali.display();
    sarmad.display();
    System.out.println("Can Ali Take Exam: " + ali.canTakeExam());
    System.out.println("Can Sarmad Take Exam: " + sarmad.canTakeExam());
  }
}
