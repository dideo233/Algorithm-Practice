package reviewing.step2.sec09polymorphism.example.abstracts;

/**
 * 추상 클래스(Abstract Class) 적용 예제
 * - 이전(PolyEx)의 문제점 개선:
 *   1. 불필요한 부모 객체 생성 방지 (new Animal 불가)
 *   2. 자식 클래스의 오버라이딩 강제 (구현 안 하면 컴파일 에러)
 */
public class AnimalAbstractEx {

    /**
     * 1. 추상 클래스 (Abstract Class)
     * - 하나 이상의 추상 메서드를 포함하여, 실체(인스턴스) 없이 추상적인 개념을 제공하는 부모 클래스.
     * - 공통된 기능은 미리 구현해둘 수 있고, 자식마다 달라야 하는 기능은 추상 메서드로 남겨둔다.
     * - [목적] 공통 기능 재사용, 상속을 통한 자식 클래스들의 규격 통일, 구현 강제 (오버라이딩).
     * - [핵심] new로 직접 객체 생성 불가. (오직 상속용)
     *
     * 2. 제약 조건 (abstract)
     * - 추상 메서드는 메서드 시그니처만 존재하고 본문(Body, {})이 없다.
     * - [강제] 자식 클래스는 부모의 추상 메서드를 반드시 오버라이딩해야 한다.
     *   > 안 하면 컴파일 오류 발생 (실수 방지).
     *
     * 3. 순수 추상 클래스
     * - 모든 메서드가 추상 메서드인 경우.
     * - 실행 로직이 전혀 없고, 구현 명세만을 제공하며 다형성을 위한 '껍데기(타입)' 역할만 수행.
     *
     * [소결: 왜 굳이 쓰는가?]
     * - 일반 클래스를 부모로 쓰면?
     *   1. 개발자가 실수로 오버라이딩을 빼먹어도 모름.
     *   2. 생성해선 안 될 부모 객체를 생성할 수 있음.
     * - 추상 클래스는 이 문제들을 '제약(컴파일 에러)'을 통해 원천 차단한다.
     *
     * [Next: 인터페이스]
     * - 순수 추상 클래스를 보니 마치 '규격(USB 포트)'과 같다.
     *   > "이 규격에 맞춰서 기능을 구현해라"
     * - 자바는 이 '순수 추상 클래스'를 더 편하게 쓰기 위해 `interface`라는 문법을 제공한다!
     */

    public static void main(String[] args) {
        // 추상 클래스는 인스턴스 생성 불가
        // Animal animal = new Animal(); // 컴파일 오류 발생

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
        animal.move();
        System.out.println("===== 동물 이동 테스트 종료 =====");
    }
}
