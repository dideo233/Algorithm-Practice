package reviewing.step3.sec01object.objectpoly;

/**
 * [Object 클래스의 다형성 - 왜 쓰나?]
 * 1. 범용적인 처리
 * - 모든 객체를 담을 수 있는 `Object[]` 배열 등을 만들면, 서로 다른 타입의 객체를 한꺼번에 관리할 수 있다.
 * - `size(Object[] objects)`와 같이, 구체적인 타입(`Dog`, `Car`)을 몰라도 동작하는 범용 메서드를 만들 수 있다.
*
 * 2. 확장성과 OCP
 * - 새로운 클래스(e.g., `Bird`)가 추가되어도, `Object`를 사용하는 기존 코드(`size` 메서드 등)는 수정할 필요가 없다.
 * - 만약 `Object`가 없다면?
 *   - `size(Dog[])`, `size(Car[])` 처럼 각 타입별로 메서드를 계속 추가해야 함 (OCP 위반).
 *   - 모든 객체를 아우르는 공통 부모가 없다면, 개발자가 직접 `MyObject` 같은 걸 정의해야 함.
 *     -> 다른 개발자가 만든 라이브러리와는 호환되지 않는 문제가 발생.
 *
 * [해결] 자바는 `Object`라는 표준을 제공하여 이 문제를 근본적으로 해결함.
 */
public class ObjectPolyEx2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();
        Object object = new Object(); // Object도 객체 생성 가능

        // 서로 다른 타입의 객체들을 하나의 배열로 묶어서 관리
        Object[] objects = {dog, car, object};
        size(objects);
    }

    // 구체적인 타입(Dog, Car)에 의존하지 않고, 배열의 길이만 구하는 범용 메서드
    private static void size(Object[] objects) {
        System.out.println("size: " + objects.length);
    }
}
