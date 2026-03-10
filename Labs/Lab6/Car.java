public class Car {
  static final int currentYear = 2026;
  String model;
  int manuFactYear;
  public Car (String model, int manuFactYear) {
    this.model = model;
    this.manuFactYear = manuFactYear;
  }
  public int old() {
    return currentYear - manuFactYear;
  }
  public void display() {
    System.out.println("Model:\t\t\t" + model);
    System.out.println("Manufacturing Year:\t" + manuFactYear);
  }
  public static void main(String[] args) {
    Car bmw = new Car("BMW M5", 2025);
    Car toyota = new Car("Toyota Crown Sedan", 2023);
    bmw.display();
    toyota.display();
    System.out.println("BMW " + bmw.old() + " years old");
    System.out.println("Toyota " + toyota.old() + " years old");
  }
}
