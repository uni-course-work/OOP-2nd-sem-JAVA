import java.util.Scanner;
import java.util.ArrayList;
public class Runner {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Tape> tapes = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("1. Add Book");
        System.out.println("2. Add Tape");
        System.out.println("0. Quit");
        System.out.println();
        while (true) {
            System.out.print("Choose your option: ");
            int option = scan.nextInt();
            scan.nextLine();
            if (option == 0) {
                break;
            }
            if (option == 1) {
                System.out.print("Enter Title: ");
                String title = scan.nextLine();
                System.out.print("Enter price: ");
                double price = scan.nextDouble();
                System.out.print("Enter pages: ");
                int pages = scan.nextInt();
                scan.nextLine();
                books.add(new Book(title, price, pages));
            } else if (option == 2) {
                System.out.print("Enter Title: ");
                String title = scan.nextLine();
                System.out.print("Enter price: ");
                double price = scan.nextDouble();
                System.out.print("Enter playing time (in seconds): ");
                int playTime = scan.nextInt();
                scan.nextLine();
                tapes.add(new Tape(title, price, playTime));
            } else {
                System.out.println("Invalid Option!");
            }
            System.out.println();
        }
        
        System.out.println("\n===============SUMMARY==============\n");
        if (books.isEmpty()) {
            System.out.println("NO BOOKS ADDED");
        } else {
            for (Book bk: books) {
               bk.display(); 
            }
        }

        if (tapes.isEmpty()) {
            System.out.println("NO TAPES ADDED");
        } else {
            for (Tape tp: tapes) {
                tp.display();
            }
        }
    }
}