## Movie
```java
public class Movie {
    static int nextId = 0;
    private String title;
    private int id;
    private double fee;

    public Movie (String title) {

        this.title = title;

        this.id = Movie.getNextId();

        this.fee = 2.0;

    }

    public Movie () {
        this("Unkown");
    }

    public static int getNextId() {
        Movie.nextId ++;
        return Movie.nextId;
    }

    public void setFee (double fee) {
        this.fee = fee;
    }

    public double getFee () {
        return this.fee;
    }  

    public double caclFees (int numberOfDays) {
        return numberOfDays * this.fee;
    }
}
```

## Action

```java
public class Action extends Movie{
    public Action (String title) {
        super(title);
        this.setFee(3.0);
    }

    @Override
    public double caclFees (int numberOfDays) {
        return numberOfDays * this.getFee();
    }
}
```

## Comedy

```java
public class Comedy extends Movie{
    public Comedy (String title) {
        super(title);
        this.setFee(2.5);
    }

    @Override
    public double caclFees (int numberOfDays) {
        return numberOfDays * this.getFee();
    }

}
```

## Drama

```java
public class Drama extends Movie {
    public Drama (String title) {
        super(title);
    }

    @Override
    public double caclFees (int numberOfDays) {
        return numberOfDays * this.getFee();
    }
}
```

## RUNNER

```java
public class Runner {

    public static void main(String[] args) {
        Action act = new Action("KGF");
        Comedy com = new Comedy("Three Idiots");
        Drama drm = new Drama("Hum sath sath hain");
        System.out.println(act.caclFees(3));
        System.out.println(com.caclFees(4));
        System.out.println(drm.caclFees(5));
    }
}
```