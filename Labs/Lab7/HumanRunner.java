class Human {
  static final int CURRENT_YEAR = 2026;
  int dateOfBirth;
  String cnic;
  public Human(int dateOfBirth, String cnic) {
    this.dateOfBirth = dateOfBirth;
    this.cnic = cnic;
  }
  public Human() {}

  int calculateAge() {
    return CURRENT_YEAR - dateOfBirth;
  }

  void display() {
    System.out.println("Year of Birth: " + dateOfBirth);
    System.out.println("CNIC: " + cnic);
    System.out.println("Age: " + calculateAge());
  }
}
public class HumanRunner {
  public static void main(String[] args) {
    Human ali = new Human(2006, "36239-75747474");
    Human cr = new Human();

    ali.display();
    cr.display();
  }
}
