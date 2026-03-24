public class Publication {
    private String title;
    private double price;

    public Publication (String title, double price) {
        this.title = title;
        this.price = price;
    }

    public void display () {
        System.out.println("Title: " + this.title);
        System.out.println("Price: " + this.price);
    }
}