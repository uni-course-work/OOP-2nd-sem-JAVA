import java.util.ArrayList;

public class TextFinallyBlock {
    public static void main(String[] args) {
        try {
            ArrayList<String> arr = null;
            arr.add("Hello");
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("Done adding String");
        }
        try {
            int data = 0/0;
            System.out.println(data);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("Arithmetic operation done");
        }
    }
}
