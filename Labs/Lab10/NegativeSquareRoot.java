import java.util.Scanner;

public class NegativeSquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Enter number to take it's square root: ");
            double num = scan.nextDouble();
            scan.nextLine();
            if (num < 0) {
                throw new NegativeNumberException();
            }
            System.out.println("Square Root of " + num + " = " + Math.sqrt(num));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
