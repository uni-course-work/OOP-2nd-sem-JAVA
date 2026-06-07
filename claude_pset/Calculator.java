// Problem 1 — Java Basics + First Class
// ⏱ 45 min
// Build a Calculator class with:

// Private fields: double result, String history (tracks every operation as a string log)
// Overloaded add(), subtract(), multiply(), divide() — each accepts either two ints or two doubles
// A getHistory() method that prints every operation done so far
// A reset() method
// A main() to demo all methods

// Concepts hit: class structure, methods, method overloading, data types, access modifiers

public class Calculator {
    private double result;
    private String history;

    public Calculator () {
        this.history = "";
    }
    public int add (int a, int b) {
        result = a + b;
        this.addToHistory(expressionBuilder(a, b, "+"));
        return a + b;
    }

    public double add (double a, double b) {
        result = a + b;
        this.addToHistory(expressionBuilder(a, b, "+"));
        return a + b;
    }

    public int subtract (int a, int b) {
        this.result = a - b;
        this.addToHistory(expressionBuilder(a, b, "-"));
        return a - b;
    }

    public double subtract (double a, double b) {
        this.result = a - b;
        this.addToHistory(expressionBuilder(a, b, "-"));
        return a - b;
    }

    public int multiply (int a, int b) {
        this.result = a * b;
        this.addToHistory(expressionBuilder(a, b, "x"));
        return a * b;
    }

    public double multiply (double a, double b) {
        this.result = a * b;
        this.addToHistory(expressionBuilder(a, b, "x"));
        return a * b;
    }

    public int divide (int a, int b) {
        this.result = a / b;
        if (b == 0) throw new ArithmeticException("Division by Zero is Undefined");
        this.addToHistory(expressionBuilder(a, b, "/"));
        return a / b;
    }

    public double divide (double a, double b) {
        this.result = a / b;
        if (b == 0.0) throw new ArithmeticException("Division by Zero is Undefined");
        this.addToHistory(expressionBuilder(a, b, "/"));
        return a / b;
    }

    public String getHistory () {
        if (history.isBlank()) {
            return "No History";
        }
        return history;
    }

    public void reset () {
        this.result = 0.0;
        this.history = "";
    }

    private void addToHistory (String expression) {
        this.history += '\n' + expression;
    }

    private String expressionBuilder (int a, int b, String sign) {
        return a + " " + sign + " " + b + " = " + this.result;
    }

    private String expressionBuilder (double a, double b, String sign) {
        return a + " " + sign + " " + b + " = " + this.result;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int a = 100;
        int b = 100;
        double c = 50.9;
        double d = 10.1;

        System.out.println(calc.add(a, b));
        System.out.println(calc.multiply(a, b));
        System.out.println(calc.subtract(a, b));
        System.out.println(calc.divide(a, b));

        System.out.println(calc.add(c, d));
        System.out.println(calc.subtract(c, d));
        System.out.println(calc.divide(c, d));
        System.out.println(calc.multiply(c, d));

        System.out.println(calc.getHistory());
        calc.reset();
        System.out.println(calc.getHistory());
    }
}