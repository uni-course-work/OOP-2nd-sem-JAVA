public class Human {
  String name;
  int ageInYear;
  String CNIC;

  public Human(String name, int ageInYear, String CNIC) {
    this.name = name;
    this.ageInYear= ageInYear;
    this.CNIC = CNIC;
  }
  public void display() {
    System.out.println("Name:\t" + name);
    System.out.println("Age:\t" + ageInYear);
    System.out.println("CNIC:\t" + CNIC);
  }
  public static void main(String[] args) {
    Human cr = new Human("Zulqarnain", 20, "234297472934");
    Human me = new Human("Abdul Samad", 21, "369297402340");
    cr.display();
    me.display();
  }
}
