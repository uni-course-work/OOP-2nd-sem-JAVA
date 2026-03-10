// Define a class Laptop with following fields
// a. Model Name
// b. Display Size
// c. Installed RAM
// You are required to create an object for Laptop class, assign values to the attributes and print the details using
// member function display()

public class Laptop {
  String model;
  int displaySize;
  int ram;

  public Laptop (String model, int displaySize, int ram) {
    this.model = model;
    this.displaySize = displaySize;
    this.ram = ram;
  }

  public void display() {
    System.out.println("Model:\t\t" + model);
    System.out.println("Display Size:\t" + displaySize);
    System.out.println("Ram:\t\t" + ram);
  }
  public static void main(String[] args) {
    Laptop dell = new Laptop("Dell Latitude 7480", 14, 16);
    Laptop hp = new Laptop("HP G8", 16, 32);

    System.out.println("Laptops details");
    dell.display();
    hp.display();
  }
}
