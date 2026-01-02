package reviewing.step3.sec01object.objectpoly;

/**
 * [Object 다형성의 기본]
 * 1. 다형적 참조와 공통 기능 제공
 * - `Object`는 모든 클래스의 최상위 부모이다.
 * - 따라서 `Object` 타입의 변수는 세상의 모든 객체를 담을 수 있다.
 *   (e.g., `Object obj = new Dog();`)
 *
 * 2. 장점과 한계
 * - 장점: 메서드의 매개변수를 `Object`로 설정하면, 어떤 타입의 객체든 인자로 받을 수 있다.
 * - 한계: `Object` 타입으로 업캐스팅(Upcasting) 되면, 자식 클래스(`Dog`, `Car`)에만 있는 메서드는 호출할 수 없다.
 *   -> `obj.sound()` (X) : 컴파일 오류 발생. `Object`에는 `sound()`가 없기 때문.
 *
 * 3. 해결책
 * - 자식의 기능을 사용하려면 `instanceof`로 타입을 확인한 후, 다운캐스팅(Downcasting) 해야 한다.
 */
public class ObjectPolyEx1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();
        action(dog);
        action(car);
    }

    private static void action(Object obj) {
        // [한계] obj는 현재 Object 타입으로 인식됨.
        // obj.sound(); // 컴파일 오류! (Object 클래스에는 sound 메서드가 없음)
        // obj.move();  // ..

        // [해결] 객체가 실제로 Dog인지 확인 후, Dog로 되돌려서(다운캐스팅) 사용
        if (obj instanceof Dog dog) {
            dog.sound();
        } else  if (obj instanceof Car car) {
            car.move();
        }
    }
}
