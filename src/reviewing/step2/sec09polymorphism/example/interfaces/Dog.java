package reviewing.step2.sec09polymorphism.example.interfaces;

public class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("강아지 이동");
    }
    
}
