package reviewing.step2.sec09polymorphism.example.interfaces;

/**
 * 인터페이스(Interface) 적용 예제
 * - 순수 추상 클래스(AnimalAbstractEx)를 자바 표준 문법인 '인터페이스'로 전환한 코드.
 */
public class AnimalInterfaceEx {

    /**
     * 1. 인터페이스 (Interface)
     * - 정의: 클래스들이 구현해야 할 기능(메서드)의 명세.
     * - 개념적으로는 '순수 추상 클래스'와 같다. (인스턴스 생성 불가, 상속 시 오버라이딩 강제, 다형성 목적)
     * - 상속에서는 제한된 다중 상속을 인터페이스는 허용한다
     *
     * - [편의 기능]
     *   > 메서드에 public abstract를 안 붙여도 자동으로 포함된 것으로 간주한다. (생략 권장)
     *   > 멤버 변수는 무조건 public static final(상수)로 간주한다. (인스턴스와 무관한 상수 정의는 가능)
     *
     * 2. 왜 '상속'이 아니라 '구현(implements)'인가?
     * - 상속(extends)은 부모의 기능과 상태를 '물려받아 확장'하는 것이 주 목적.
     * - 반면 인터페이스는 물려받을 기능(로직)이 없고, 오히려 정의된 메서드를 오버라이딩하여 구현하여야 함
     *   > 용어의 차이는 이런 맥락
     *
     * 3. 인터페이스를 사용하는 이유
     * - 추상 클래스는 "일부 기능 공유 + 일부 구현 강제"인 반면, 인터페이스는 "모든 기능의 구현을 강제"한다. (가장 엄격한 규격)
     *   > "이 기능 넣을까 말까" 고민할 필요 없이, 완벽하게 '설계'와 '구현'을 분리하게 해줌.
     * - 클래스 상속은 하나만 가능하지만, 인터페이스는 여러 개를 구현할 수 있다
     *
     * [소결]
     * - 결국 상속만으로도 다형성은 되지만, 인터페이스는 '더 안전하고 엄격한 규격'을 제공한다.
     * - 인터페이스를 쓴다 = 이를 구현하는 자식 클래스 만들고 구현해야 한다
     *   > 개발자는 이를 보고 "다형성을 위한 설계구나"라고 이해할 수 있다!
     *
     * [NEXT] 그런데 왜 다중 상속과 달리 다중 구현은 허용되는 것일까?
     */

    public static void main(String[] args) {

        Cat cat = new Cat();
        Dog dog = new Dog();
        Cow cow = new Cow();

        soundAnimal(cat);
        soundAnimal(dog);
        soundAnimal(cow);

        // 코드상으로는 추상 클래스 때와 똑같아 보이지만,
        // 인터페이스를 사용함으로써 '다중 구현'의 유연함과 더욱 강한 추상화 효과를 얻는다.

    }

    private static void soundAnimal(Animal animal) {
        System.out.println("===== 동물 소리 테스트 시작 =====");
        animal.sound();
        System.out.println("===== 동물 소리 테스트 종료 =====");
    }
}
