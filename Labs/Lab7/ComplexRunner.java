class Complex {
    private double real;
    private double imaginary;
    public Complex (double real, double imaginary) {
      this.real = real;
      this.imaginary = imaginary;
    }
    public Complex () {
        this(0.0, 0.0);
    }
    
    public void setReal (double real) {
        this.real = real;
    }

    public double getReal () {
        return this.real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getImaginary () {
        return this.imaginary;
    }

    public void display () {
        System.out.println(this.real + " + " + this.imaginary + "i");
    }

    public void doubleReal () {
        this.real *= 2.0;
    }
}
public class ComplexRunner {
    public static void main(String[] args) {
        Complex num1 = new Complex();
        Complex num2 = new Complex(4, 3);
        num1.display();
        num2.display();
        num2.doubleReal();
        num2.setImaginary(5);
        num2.display();
    }
}

// Define a class Complex with two attributes, i.e. real and imaginary. Define the constructors,
// getter, setter and display method. The display method will display the complex number in
// proper format, e.g. 2+3i.
// Also define a method doubleReal() which will double the real value, i.e. if real=2, this
// method will make it real=4
// Inside runner class, create two objects of this class. First with default constructor and second
// with parameterized constructor (where real=4, img=3 for second object)
// Call display method for objects. Then call doubleReal() method for second object, also
// change it’s imaginary value to 5. And finally call display() method again.