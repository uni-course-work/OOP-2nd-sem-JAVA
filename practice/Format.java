public class Format {
  public static void main(String[] args) {
    int n= 23423;
    double d = 2384.29842384;
    String text = "Hello form NUML";
    System.out.println("Integer Formatted to: " + format(n));
    System.out.println("Double Formatted to: " + format(d));
    System.out.println("String Formatted to: " + format(text));
  }
  public static String format(int n) {
    return "$" + Integer.toString(n);
  }
  public static String format(String s) {
    return " " + s + " ";
  }
  public static String format (double n) {
    String tokens [] = Double.toString(n).split("\\.");
    return tokens[0] + "." + tokens[1].substring(0, 2);
  }
}
