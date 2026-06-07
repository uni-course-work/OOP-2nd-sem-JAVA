public class FullTimeEmployee extends Employee {
    private int annualBonus;

    public FullTimeEmployee (String name, int age, String CNIC, String employeeId, String department, double salary, int annualBonus) {
        super(name, age, CNIC, employeeId, department, salary);
        this.annualBonus = annualBonus;
    }

    @Override
    public double calculatePay () {
        return this.getSalary () + this.annualBonus;
    }

    @Override
    public String toString () {
        return super.toString() + " Pay: " + this.calculatePay();
    }
}