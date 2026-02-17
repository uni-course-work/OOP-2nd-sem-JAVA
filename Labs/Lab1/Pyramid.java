public class Pyramid {
  public static void main(String[] args) {
    String stars = "*****";
    int num = stars.length();
    for (int i = 0; i < num; i++) {
      System.out.println(stars);
      stars = stars.substring(0, num - (i + 1));
    }
  }
}