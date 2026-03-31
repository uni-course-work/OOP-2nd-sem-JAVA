public class Movie {
    static int nextId = 0;
    private String title;
    private int id;
    private double fee;

    public Movie (String title, double fee) {
        this.title = title;
        this.id = Movie.getNextId();
        this.fee = fee;
    }
    public Movie (String title) {
        this(title, 2);
    }

    public Movie () {
        this("Unkown");
    }
    public static int getNextId() {
        Movie.nextId ++;
        return Movie.nextId;
    }

    public double caclFees (int numberOfDays) {
        return numberOfDays * this.fee;
    }
    @Override

    public String toString () {
        return "Movie " +  this.id +  " " + this.title;
    }
}