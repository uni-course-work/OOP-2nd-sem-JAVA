import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius of Circle: ");
        double radius = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter length of Rectangle: ");
        double length = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter width of Rectangle: ");
        double width = scanner.nextDouble();
        scanner.nextLine();
        Circle c = new Circle(radius);
        Rectangle r = new Rectangle(length, width);
        System.out.println("Area of Rectangle: " + r.calculateArea());
        System.out.println("Perimeter of Rectangle: " + r.calculatePerimeter());
        System.out.println("Area of Circle: " + c.calculateArea());
        System.out.println("Perimeter of Circle: " + c.calculatePerimeter());
        scanner.close();
    }
}