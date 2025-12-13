package reviewing.step2.sec09polymorphism.example.abstracts;

public class Cat extends Animal {

    @Override
    public void sound() {
        System.out.println("냥냥");
    }

    @Override
    public void move() {
        System.out.println("고양이 이동");
    }

}
