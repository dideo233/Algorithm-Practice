package reviewing.step3.sec02immutability;

/**
 * [공유 참조와 불변 객체(Immutable Object)]
 *
 * 1. 공유 참조와 사이드 이펙트
 *    - 기본형(Primitive)은 값을 복사하므로 서로 독립적이다.
 *    - 참조형(Reference)은 메모리 주소를 복사하므로, 하나의 객체를 여러 변수가 공유한다.(Shared Reference)
 *      이 상태에서 객체의 값을 변경하면, 이를 참조하는 모든 변수에 영향을 미친다(Side Effect).
 *
 * 2. 해결책: 불변 객체(Immutable Object)
 *    - 객체를 공유하는 것 자체는 막을 수 없다. (메모리 효율상 필요함)
 *    - 대신, 객체의 내부 상태(값)를 아예 수정할 수 없게 막아버린다.
 *    - 값을 바꾸고 싶으면 새로운 객체를 생성해서 할당해야 한다.
 *
 * [참고: 가변(Mutable) vs 불변(Immutable) 객체]
 * A. 가변 객체
 *    - 생성 이후에도 내부 상태(필드 값)를 변경할 수 있는 객체.
 *    - 주로 `Setter` 메서드를 통해 값을 수정함.
 *
 * B. 불변 객체
 *    - 생성 시점 이후에는 내부 상태가 절대 변하지 않는 객체.
 *    - 구현 방법:
 *      1. 모든 필드를 `private final`로 선언 (생성자를 통해서만 초기화, 이후 수정 불가).
 *      2. `Setter`를 아예 만들지 않음.
 *    - 값 변경 방식:
 *      - 내부 값을 수정하는 대신, 변경된 값을 가진 '새로운 객체'를 생성(`new`)하여 반환함.
 */
public class DataTypeEx {
    public static void main(String[] args) {
        /**
         * [1. 기본형(Primitive Type)의 특징]
         * - 값을 그대로 복사하여 대입한다.
         * - 각 변수는 서로 다른 메모리 공간을 가지므로 영향을 주지 않는다.
         */
        System.out.println("--- 1. 기본형: 값 복사 (사이드 이펙트 X) ---");
        int primitive1 = 10;
        int primitive2 = primitive1; // 값(10)을 복사
        primitive2 = 20; // primitive2만 변경됨
        System.out.println("primitive1 = " + primitive1); // 10 (영향 없음)
        System.out.println("primitive2 = " + primitive2); // 20


        /**
         * [2. 참조형(Reference Type)의 문제점: 공유 참조]
         * - 객체의 메모리 주소(참조값)를 복사하여 대입한다.
         * - 두 변수가 하나의 인스턴스를 바라보게 된다.
         */
        System.out.println("\n--- 2. 참조형: 공유 참조와 사이드 이펙트 발생 ---");
        Address ref1 = new Address("서울");
        Address ref2 = ref1; // 참조값 복사

        // [사이드 이펙트 발생]
        // ref2의 주소를 부산으로 바꿨는데, 의도하지 않은 ref1도 변경
        // 원인: ref1과 ref2가 '같은 객체'를 보고 있기 때문.
        ref2.setValue("부산");
        System.out.println("ref1 = " + ref1); // 부산 (의도치 않은 변경!)
        System.out.println("ref2 = " + ref2); // 부산

        /**
         * [3. 개발자의 실수 가능성]
         * - 사이드 이펙트는 서로 다른 객체를 참조하도록 설계하면 문제는 해결된다.
         * - 하지만, 개발자가 실수로 `refA = refB` 처럼 공유 참조 코드를 작성하는 것을 문법적으로 막을 방법은 없다.
         */
        System.out.println("\n--- 3. 개발자의 실수 시나리오 ---");
        Address ref3 = new Address("서울");
        Address ref4 = ref3; // 실수로 공유 참조 생성

        // 복잡한 로직 안에서 사이드 이펙트가 발생하면 찾기 매우 어렵다.
        changeAddress(ref3, "부산");
        System.out.println("ref3 = " + ref3); // 부산 (의도치 않은 변경!)
        System.out.println("ref4 = " + ref4); // 부산

        /**
         * [4. 근본적인 해결책: 불변 객체(Immutable Object)]
         * - 공유 참조를 막을 수 없다면, '공유된 객체의 값 변경'을 원천 차단한다.
         * - 객체의 값을 변경할 수 없으므로 사이드 이펙트가 발생할 수 없다.
         */
        System.out.println("\n--- 4. 불변 객체 도입 (사이드 이펙트 원천 차단) ---");
        ImmutableAddress immutableRef1 = new ImmutableAddress("서울");
        ImmutableAddress immutableRef2 = immutableRef1; // 공유 참조는 여전히 발생

        // [변경 불가]
        // immutableRef2.setValue("부산"); // 컴파일 에러! 불변 객체는 값 변경 메서드가 없음.

        // [새로운 객체 생성]
        // 값을 바꾸고 싶다면, 새로운 객체를 생성하여 변수에 갈아끼워야(재할당) 한다.
        immutableRef2 = new ImmutableAddress("부산");
        System.out.println("immutableRef1 = " + immutableRef1); // 서울 (값 유지됨)
        System.out.println("immutableRef2 = " + immutableRef2); // 부산 (새로운 객체)

        // 결론: 불변 객체는 값을 수정할 수 없으므로, 공유되어도 안전하다.
    }

    public static void changeAddress(Address address, String changeAddress) {
        System.out.println("change address: " + changeAddress);
        address.setValue(changeAddress);
    }
}

