import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(10));
        shapes.add(new Rectangle(10, 20));
        shapes.add(new Triangle(5, 4, 7));

        for (Shape shape: shapes) {
            shape.printInfo();
        }
        System.out.println("Largest Shape: " + Shape.largestShape(shapes));
    }
}
