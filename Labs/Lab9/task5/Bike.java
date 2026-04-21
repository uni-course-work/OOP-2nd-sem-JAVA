public class Bike implements Vehicle{
    private String brand;
    private String type;
    private int speed;

    public Bike (String brand, String type, int speed) {
        this.brand = brand;
        this.type = type;
        this.speed = speed;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting Bike Engine!");
    }

    @Override
    public void stopEngine () {
        System.out.println("Stopping Bike Engine!");
    }

    @Override
    public int getVehSpeed () {
        return this.speed;
    }
}