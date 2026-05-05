import java.util.Scanner;

public class Exercise3 {
    public static double m1 (double num) throws NegativeNumberException {
        if (num < 0) {
            throw new NegativeNumberException();
        }
        return Math.sqrt(num);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Enter number to take it's square root: ");
            double num = scan.nextDouble();
            scan.nextLine();
            System.out.println("Square Root of " + num + " = " + m1(num));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}