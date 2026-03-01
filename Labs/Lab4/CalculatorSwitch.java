import java.util.Scanner;

public class CalculatorSwitch {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter first Number: ");
    double firstNum = scanner.nextDouble();
    System.out.print("Enter Second Number: ");
    double secondNum = scanner.nextDouble();
    System.out.println("Press + for addition, * for multiplication,\n / for division and - for subraction");
    System.out.print("Enter Operator: ");
    char operator = scanner.next().charAt(0);
    double result = switch (operator) {
      case '+' -> firstNum + secondNum;
      case '-' -> firstNum - secondNum;
      case '/' -> firstNum / secondNum;
      case '*' -> firstNum * secondNum;
      default -> 0.0;
    };
    scanner.close();
    System.out.printf("%.2f %c %.2f = %.2f%n", firstNum, operator, secondNum, result);
  }
}