public class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee (String name, int age, String CNIC, String employeeId, String department, int hoursWorked, double hourlyRate) {
        super(name, age, CNIC, employeeId, department, 0.0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePay () {
        return this.hoursWorked * this.hourlyRate;
    }

    @Override
    public String toString () {
        return super.toString() + " Pay: " + this.calculatePay();
    }
}