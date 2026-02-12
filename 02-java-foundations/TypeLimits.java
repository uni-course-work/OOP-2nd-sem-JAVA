public class TypeLimits {
	public static void main(String[] args) {
    System.out.println("Maximum Value of Integer: " +  Integer.MAX_VALUE);
		System.out.println("Minimum Value of Integer: " + Integer.MIN_VALUE);
		System.out.println("Maximum Value of Float: " + Float.MAX_VALUE);
		System.out.println("Minimum Value of Float: " + Float.MIN_VALUE);
		System.out.println("Maximum Value of Double: " + Double.MAX_VALUE);
		System.out.println("Minimum Value of Double: " + Double.MIN_VALUE);
		System.out.println("Maximun Value of Byte: " + Byte.MAX_VALUE);
		System.out.println("Minimun Value of Byte: " + Byte.MIN_VALUE);
		System.out.println("Maximum Value of Short: " + Short.MAX_VALUE);
		System.out.println("Minimum Value of Short: " + Short.MIN_VALUE);
		System.out.println("Maximum Value of Long: " + Long.MAX_VALUE);
		System.out.println("Minimum Value of Long: " + Long.MIN_VALUE);
		System.out.println("Maximum Value of Char: " + Character.MAX_VALUE);
		System.out.println("Minimum Value of Char: " + Character.MIN_VALUE);
		System.out.println("Overflow: " + Integer.MAX_VALUE + " + 1 = " + (Integer.MAX_VALUE + 1));
		System.out.println("Underflow: " + Double.MIN_VALUE + " - 1 = " + (Double.MIN_VALUE - 1));
		System.out.println("Precision Loss: " + " 0.1 + 0.2 = 0.3 Evaluates to " + (0.1 + 0.2  == 0.3) + "\nOriginal Answer = " + (0.1 + 0.2));
	}
}