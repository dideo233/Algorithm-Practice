package reviewing.step2.sec09polymorphism.example.diamond;

/**
 * 다중 구현과 다이아몬드 문제 (Diamond Problem)
 */
public class DiamondEx {

    /**
     * [상속 vs 구현]
     * 1. 다중 상속이 금지된 이유 (클래스)
     *   - 부모 A와 부모 B가 똑같은 `method()`를 가지고 있을 때,
     *     자식이 `super.method()`를 호출하면 누구 걸 실행해야 할지 모름. (모호성 발생)
     *   - 이를 '다이아몬드 문제'라고 함.
     *
     * 2. 다중 구현이 허용되는 이유 (인터페이스)
     *   - 인터페이스 A와 B가 똑같은 `method()`를 가지고 있어도 문제없음. 실행 로직은 오직 자식에서만 구현됨!
     *     자식에서 구현되었다면, 오버라이딩에 의해 자식에서 구현된 메서드가 호출될 뿐이다.
     *   - 즉 다이아몬드 문제의 핵심인 "어떤 부모를 골라야 하나?"라는 모호성 자체가 없다.
     */

    public static void main(String[] args) {
        InterfaceA a = new Child();
        a.methodA();
        a.methodCommon(); // InterfaceA의 methodCommon() 호출 -> 오버라이딩된 Child의 메서드 실행

        InterfaceB b = new Child();
        b.methodB();
        b.methodCommon(); // InterfaceB의 methodCommon() 호출 -> 오버라이딩된 Child의 메서드 실행

        // [결론]
        // 부모 타입(A, B)이 무엇이든, 실제 실행되는 건 유일하게 구현된 Child의 메서드다.

    }
}
