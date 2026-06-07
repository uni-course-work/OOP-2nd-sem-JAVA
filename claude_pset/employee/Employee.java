public class Employee extends Person {
    private String employeeId;
    private String department;
    private double salary;

    public Employee (String name, int age, String CNIC, String employeeId, String department, double salary) {
        super(name, age, CNIC);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    public double calculatePay () {
        return this.salary;
    }

    public double getSalary () {
        return this.salary;
    }

    @Override
    public String toString () {
        return super.toString() + " Employee ID: " + this.employeeId + " Department: " + this.department;
    }
}