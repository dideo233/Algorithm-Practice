package reviewing.step2.sec09polymorphism.example.diamond;

public class DiamondEx {

    /**
     * [상속 vs 구현]
     * 다중 상속은 안 되는데 다중 구현은 되는 까닭은?
     *   - 다중 상속 시 두 부모 클래스의 메서드명 중복 시 무엇을 상속 받는지 애매한 문제 발생
     *   - 그러나 모든 메서드가 추상 메서드로 된 인터페이스의 경우, 기능을 자식에서 구현하여야 함!
     *   (상위 인터페이스 둘에 같은 이름 메서드 있어도, 오버라이딩(우선권!)에 의해 자식에서 구현된 메서드가 호출될 뿐이다! 즉 다이아몬드 문제 x)
     *   - 다이아몬드 문제의 핵심은 어떤 부모를 골라야 하나? 라는 모호성 자체가 없다
     */
    public static void main(String[] args) {
        InterfaceA a = new Child();
        a.methodA();
        a.methodCommon();
        //변수 a는 InterfaceA 타입 > 해당 타입의 methodCommon() 탐색 > 오버라이딩 되어 있어 Child의 methodCommon 호출

        InterfaceB b = new Child();
        b.methodB();
        b.methodCommon();
        //변수 b는 InterfaceB 타입 > 해당 타입의 methodCommon() 탐색 > 오버라이딩 되어 있어 Child의 methodCommon 호출

    }
}
