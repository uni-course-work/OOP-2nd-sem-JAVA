## Movie

```java
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
```

## Action

```java
public class Action extends Movie{
    public Action (String title) {
        super(title, 3.0);
    }
}
```

## Comedy

```java
public class Comedy extends Movie{
    public Comedy (String title) {
        super(title, 3.0);
    }
}
```

## Drama

```java
public class Drama extends Movie{
    public Drama (String title) {
        super(title, 2.0);
    }
}
```

## Runner Class

```java
public class Runner {
    public static void main(String[] args) {
        Action act = new Action("KGF");
        Comedy com = new Comedy("Three Idiots");
        Drama drm = new Drama("Hum sath sath hain");
        System.out.println(act + " has late fees of: " + act.caclFees(3));
        System.out.println(com + " has late fees of: " + com.caclFees(4));
        System.out.println(drm + " has late fees of: " + drm.caclFees(5));
    }
}
```