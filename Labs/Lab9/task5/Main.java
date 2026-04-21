public class Main {
    public static void main(String[] args) {
        Car c = new Car("Honda", "H-22", 200);
        Bike b = new Bike("Honda", "CG-125", 150);
        c.startEngine();
        c.stopEngine();
        System.out.println("Speed of Car: " + c.getVehSpeed());
        b.startEngine();
        b.stopEngine();
        System.out.println("Spped of Bike: " + b.getVehSpeed());
    }
}