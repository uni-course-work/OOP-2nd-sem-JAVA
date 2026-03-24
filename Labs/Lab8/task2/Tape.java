public class Tape extends Publication {
    private int playTime; // In seconds
    public Tape (String title, double price, int playTime) {
        super(title, price);
        this.playTime = playTime;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Play Time: " + this.playTime);
    }
}