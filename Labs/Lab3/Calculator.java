import java.util.Scanner;
public class Calculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter First Number: ");
    double firstNum = scanner.nextDouble();
    System.out.print("Enter Second Number: ");
    double secondNum = scanner.nextDouble();
    System.out.println("* for Multiplication\t / for Division\n+ for Addition and \t- for Subtraction");
    System.out.print("Enter Operator: ");
    String operator = scanner.next().trim();
    double result;
    if ("+".equals(operator)) {
      result = firstNum + secondNum;
    } else if ("-".equals(operator)) {
      result = firstNum - secondNum;
    } else if ("*".equals(operator)) {
      result = firstNum * secondNum;
    } else if ("/".equals(operator)) {
      if (secondNum == 0) {
        System.out.println("MATH ERROR: Division By Zero");
        return;
      }
      result = firstNum / secondNum;
    } else {
      System.out.println("UNKOWN OPERATION " + operator);
      return;
    }
    System.out.printf(" %.2f %s %.2f = %.2f\n", firstNum, operator, secondNum, result);
  }
}