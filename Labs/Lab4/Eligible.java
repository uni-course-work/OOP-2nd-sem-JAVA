import java.util.Scanner;
public class Eligible {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your Metric Total Marks: ");
    double totalMetricMarks = scanner.nextDouble();
    System.out.print("Enter your Metric Marks: ");
    double metricMarks = scanner.nextDouble();
    System.out.print("Enter you Intermediate Total Marks: ");
    double totalInterMarks = scanner.nextDouble();
    System.out.print("Enter Your Intermediate Marks: ");
    double interMarks = scanner.nextDouble();
    scanner.close();
    double metricPercentage = (metricMarks / totalMetricMarks) * 100.0;
    double interPercentage = (interMarks / totalInterMarks) * 100.0;

    System.out.printf("Your Metric Percentage: %.2f%%%nYour Inter Percentage: %.2f%%%n", metricPercentage, interPercentage);
    if (metricPercentage > 60.0 && interPercentage > 80.0) {
        System.out.println("Congratulations, Your are eligible to get admission in Engineering university");
    } else {
        System.out.println("Sorry, But you are not eligible to get admission in Engineering university");
    }
  }
}
