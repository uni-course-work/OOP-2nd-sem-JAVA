import java.util.Scanner;
public class Calculator {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter First Number: ");
        double first = Double.parseDouble(scanner.next());
        System.out.print("Enter Operation: ");
        char operation = scanner.next().charAt(0);
        System.out.print("Enter Second Number: ");
        double second = Double.parseDouble(scanner.next());
        scanner.close();
        double result = 0;
        switch (operation) {
            case '+':
                result = add(first, second);
                break;
            case '-':
                result = sub(first, second);
                break;
            case '*':
                result = mul(first, second);
                break;
            case '/':
                result = div(first, second);
                break;
            default:
                break;
        }
        System.out.printf("%.4f %c %.4f = %.4f\n", first, operation, second, result);
    }

    public static double add (double a, double b) { return a + b; }
    public static double sub (double a, double b) { return a - b; }
    public static double div (double a, double b) { return a / b; }
    public static double mul (double a, double b) { return a * b; }
}