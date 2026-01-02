package reviewing.step3.sec01object.tostring;

/**
 * [toString() 오버라이딩과 다형성]
 * 1. 오버라이딩 (Overriding)
 * - `Car`: `toString()`을 재정의하지 않음 -> 기본 참조값(주소 정보) 출력.
 * - `Dog`: `toString()`을 재정의함 -> 객체의 내부 데이터(이름, 나이) 출력.
 *
 * 2. 다형적 참조와 메서드 호출
 * - `ObjectPrinter.print(Object obj)`: 매개변수로 모든 타입의 객체를 받을 수 있음 (다형적 참조).
 * - 실행 시(`Run-time`), 실제 인스턴스(`Car` 혹은 `Dog`)에 정의된 `toString()`이 호출됨 (오버라이딩 우선).
 *   -> 이를 통해 모든 객체의 정보를 일관된 방식으로 출력하는 기능을 만들 수 있음.
 *
 * [참고: 의존 관계]
 * - 정적 의존 관계: 코드(클래스)만 보고 알 수 있는 관계. (e.g., ObjectPrinter는 Object를 파라미터로 쓴다.)
 * - 동적 의존 관계: 실행 시점에 결정되는 관계. (e.g., ObjectPrinter에 실제로 Car가 들어올지, Dog가 들어올지 실행해봐야 안다.)
 */
public class ToStringEx2 {
    public static void main(String[] args) {
        Car car = new Car("Model Y");
        Dog dog1 = new Dog("Dog1", 2);
        Dog dog2 = new Dog("Dog2", 5);

        System.out.println("1. 단순 toString 호출");
        System.out.println(car.toString()); // 기본: 참조값 출력
        System.out.println(dog1.toString()); // 재정의: 내용(이름, 나이) 출력

        System.out.println("\n2. println 내부에서 toString 호출");
        System.out.println(car);
        System.out.println(dog1);

        System.out.println("\n3. Object 다형성 활용 (ObjectPrinter)");
        // 하나의 메서드(print)로 다양한 객체의 정보를 출력
        ObjectPrinter.print(car);
        ObjectPrinter.print(dog1);
        ObjectPrinter.print(dog2);

        // toString()을 재정의하면 원래의 참조값(해시코드)을 볼 수 없게 됨. 이때\ System.identityHashCode() 사용
        System.out.println("\n4. 참조값 직접 확인 (System.identityHashCode)");
        String refValue = Integer.toHexString(System.identityHashCode(dog1));
        System.out.println("dog1의 실제 참조값: " + refValue);
    }
}
