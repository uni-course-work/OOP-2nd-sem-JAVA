public class Main {
    public static void main (String[] args) {
        FullTimeEmployee arif = new FullTimeEmployee("Arif", 20, "3527349723974", "3234","Computer Science",1239212,23423);
        PartTimeEmployee sarif = new PartTimeEmployee("Sarif", 18, "2342432342423", "23423", "Finance", 30, 2323);
        FullTimeEmployee jarif = new FullTimeEmployee("Jarif", 21, "3527349343974", "3144","General Science",12212,233523);
        PartTimeEmployee warif = new PartTimeEmployee("Sarif", 28, "2342432342423", "423", "Delivery", 40, 1523);

        Employee [] employees = {arif, sarif, jarif, warif};
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}