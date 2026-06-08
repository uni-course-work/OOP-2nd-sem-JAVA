import java.util.Comparator;
import java.util.List;

public abstract class Shape {
    public abstract double area ();
    public abstract double perimeter ();
    public final void printInfo () {
        System.out.println("Area: " + String.format("%.4f", this.area()));
        System.out.println("Perimeter: " + String.format("%.4f", this.perimeter()));
    }

    public final static Shape largestShape (List<Shape> shapes) {
        return shapes.stream().max(Comparator.comparingDouble(Shape::area)).orElse(null);
    }
}