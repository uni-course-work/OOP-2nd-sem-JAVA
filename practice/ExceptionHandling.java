import java.util.Scanner;
public class ExceptionHandling {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[4]);
        } catch (Exception e) {
            System.out.println(e);
        }  
    }

}
