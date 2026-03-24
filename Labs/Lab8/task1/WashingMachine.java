public class WashingMachine extends Appliance {
    private String modelName;
    private int loadCapacity;

    public WashingMachine (String modelName, int loadCapacity) {
        this.modelName = modelName;
        this.loadCapacity = loadCapacity;
        this.setElectric(true);
    }

    public WashingMachine () {
        this("PANASONIC NA-S96FC1WSG", 8);
    }

    public void display () {
        System.out.println("Elictric: " + (this.getElectric() ? "Yes" : "No"));
        System.out.println("Model Name: " + this.modelName );
        System.out.println("Load Capacity: " + this.loadCapacity + "kg");
    }

}