package reviewing.step2.sec08Inheritance.example;

public class ElectricCar extends Car {

    @Override
    public void move(){
        System.out.println("전기차를 빠르게 이동합니다.");
    }

    public void charge() {
        System.out.println("전기를 충전합니다.");
    }

    public void fillHydrogen(){
        System.out.println("수소를 충전합니다");
    }
}
