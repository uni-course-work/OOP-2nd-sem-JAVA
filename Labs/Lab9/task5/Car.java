public class Car implements Vehicle {
    private String make;
    private String model;
    private int speed;

    public Car (String make, String model, int speed) {
        this.make = make;
        this.model = model;
        this.speed = speed;
    }
    @Override
    public void startEngine() {
        System.out.println("Starting Car Engine");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping Car Engine");
    }

    @Override
    public int getVehSpeed() {
        return this.speed;
    }
}