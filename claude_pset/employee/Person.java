public class Person {
    private String name;
    private int age;
    private String CNIC;

    public Person (String name, int age, String CNIC) {
        this.name = name;
        this.age = age;
        this.CNIC = CNIC;
    }

    @Override
    public String toString () {
        return "Name: " + name + " Age: " + age + " CNIC: " + CNIC;
    }
}