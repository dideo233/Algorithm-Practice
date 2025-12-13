package reviewing.step2.sec09polymorphism.example.abstracts;

public class AnimalAbstractEx {

    /**
     * 1. 추상 클래스
     * - 하나 이상의 추상 메서드를 포함하는 클래스로, 객체 생성이 불가능하며 메서드의 구현(오버라이딩)을 강제하는 클래스 (공통된 구조와 기능을 정의하는 목적)
     * - 추상적인 개념을 제공하는 클래스로, 실체인 인스턴스 생성 불가한 클래스
     * - 상속이 목적, new 방지
     *
     * 2. 제약
     * - 추상 메서드 선언 시 abstract 키워드 붙임. body 부분 존재하지 않음 (하위에서 구현 강제)
     * - 추상 메서드는 하위 계층의 자식 클래스에서 반드시 오버라이딩 되어야 한다
     * - 추상 메서드 하나라도 존재할 시 abstract로 선언
     *   - 모든 메서드가 추상 메서드면 '순수 추상 클래스'라고 함
     *   > 실행 로직이 일절 없음. 다형성을 위한 부모 타입으로서 껍데기 역할만 함
     *   > (new 불가, 모든 메서드의 오버라이딩 강제, 주로 다형성 목적)
     *
     * [소결]
     *   제약이 추가된 클래스로 이해해도 무방.
     *   추상 클래스로 기능하는 부모 클래스를 일반 클래스로 정의할 경우, 인스턴스를 생성하거나 오버라이딩을 안 하는 문제가 발생
     *   > 순수 추상 클래스로 이를 방지
     * 
     * [추가]
     *   > 이런 특정을 보면, 어떤 규격을 제공하는 듯 보인다. 
     *   > 일반적으로 이야기하는 USB의 인터페이스와 같은. 규격에 맞춰 제품을 구현하는.
     *   > 그래서 아예 순수 추상 클래스를 더 편리하게 쓸 수 있는 interface라는 기능이 있다!
     */

    public static void main(String[] args) {
        //추상 클래스는 생성 불가
        //Animal animal = new Animal();

        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        cat.sound();
        cat.move();;

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(cow);
    }

    public static void soundAnimal(Animal animal) {
        System.out.println("===== 동물 소리 테스트 시작 =====");
        animal.sound();
        System.out.println("===== 동물 소리 테스트 종료 =====");
    }
    
    public static void moveAnimal(Animal animal) {
        System.out.println("===== 동물 이동 테스트 시작 =====");
        animal.sound();
        System.out.println("===== 동물 이동 테스트 종료 =====");
    }
}
