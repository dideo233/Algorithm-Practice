package reviewing.step2.sec09polymorphism.example.abstracts;

public class Cow extends Animal {

    @Override
    public void sound() {
        System.out.println("음메");
    }

    @Override
    public void move() {
        System.out.println("소 이동");
    }

}
