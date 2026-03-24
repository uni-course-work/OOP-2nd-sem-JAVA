public class Book extends Publication {
    private int pages;
    public Book (String title, double price, int pages) {
        super(title, price);
        this.pages = 0;
    }

    @Override
    public void display () {
        super.display();
        System.out.println("Pages: " + this.pages);
    }
}