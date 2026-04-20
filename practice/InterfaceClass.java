interface Animal {
    public void sound();
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat sounds");
    }
}
public class InterfaceClass {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.sound();
    }
}
