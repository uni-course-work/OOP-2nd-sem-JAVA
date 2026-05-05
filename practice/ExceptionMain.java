import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Your age: ");
        int age = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Your GPA: ");
        double gpa = scan.nextDouble();
        scan.nextLine();

        try {
            if (age > 25) {
                throw new AgeOutOfRangeException();
            }
            try {
                if (gpa < 2.5) {
                    throw new LowGpaException();
                }
            }
            catch (LowGpaException e) {
                System.out.println(e);
            }
        } catch (AgeOutOfRangeException e) {
            System.out.println(e);
        }
    }
}
