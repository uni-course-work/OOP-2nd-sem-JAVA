class SimpleCalculator {
    private double num1;
    private double num2;

    public void setNumbers (double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add () {
        double result = this.num1 + this.num2;
        this.display("+", result);
        return result;
    }
    public double sub () {
        double result = this.num1 - this.num2;
        this.display("-", result);
        return result;
    }
    public double mul () {
        double result = this.num1 * this.num2;
        this.display("+", result);
        return result;
    }
    public double div () {
        if (this.num2 == 0) {
            throw new IllegalArgumentException("Can't divide by 0");
        }
        double result = this.num1 / this.num2;
        this.display("/", result);
        return result;
    }
    public void display (String operation, double result) {
        System.out.println(this.num1 + " " +  operation  + " " + this.num2 + " = " + result);
    }
}

public class SimpleCalculatorRunner {
    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
        calc.setNumbers(10, 5);
        calc.add();
        calc.sub();
        calc.mul();
        calc.div();
    }
}

// Write a program that declares a class SimpleCalculator that has two data members num1 and
// num2 to store two numbers. It also has following member functions.
// i.
//  The add() function adds two numbers and displays the result and return the answer.
// ii.
//  The sub() function subtracts two numbers and displays the result and return the answer
// iii.
//  The mul() function multiplies two numbers and displays the result and return the
// answer
// iv.
//  The div() function divides two numbers and displays the result and return the answer.
// v. The SumOfSqaureRoot() method that take squareRoot of the numbers , add them and
// return the answer.
// (Note: You need to use Math library for this task)
// Inside runner class, create object of SimpleCalculator class using default constructor, assign it
// values (e.g. num1=10, num2=5) and call all methods for the object.