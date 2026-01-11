package reviewing.step3.sec05enum.ex02typesafe;


/**
 * 타입 안전 열거형 패턴 (Type-Safe Enum Pattern)
 * - 클래스를 이용하여 열거형을 직접 구현하는 방식.
 * - 핵심: 'private 생성자'를 통해 외부에서 임의로 객체를 생성하는 것을 막고,
 *        미리 정의된 상수 객체(BASIC, GOLD, DIAMOND)만 사용하도록 강제함.
 */
public class ClassGradeEx {

    public static void main(String[] args) {

        /**
         * 1. Enum 패턴의 원리 (참조값 비교)
         * - '상수'로 선언된 BASIC, GOLD, DIAMOND는 각각 다른 참조값(주소)을 가진 인스턴스다.
         * - 즉, 값 자체가 아니라 '객체의 주소'를 통해 등급을 구분한다.
         */
        System.out.println("--- 1. Enum 원리 검증 ---");
        // getClass()는 모두 동일한 ClassGrade 클래스임
        System.out.println("class BASIC = " + ClassGrade.BASIC.getClass());
        System.out.println("class GOLD = " + ClassGrade.GOLD.getClass());
        System.out.println("class DIAMOND = " + ClassGrade.DIAMOND.getClass());

        // 참조값(toString)은 서로 다름 -> 서로 다른 객체임을 증명
        System.out.println("ref BASIC = " + ClassGrade.BASIC);
        System.out.println("ref GOLD = " + ClassGrade.GOLD);
        System.out.println("ref DIAMOND = " + ClassGrade.DIAMOND);

        /**
         * 2. 실제 사용 (타입 안전성)
         * - 메서드의 파라미터가 ClassGrade 타입이므로, 오직 정해진 상수만 전달 가능.
         * - 오타나 엉뚱한 문자열이 들어올 틈이 없음. (문자열 상수 사용 시의 단점 해결)
         */
        System.out.println("\n--- 2. 타입 안전성 활용 ---");
        int price = 10000;
        DiscountService discountService = new DiscountService();
        System.out.println("BASIC 할인: " + discountService.discount(ClassGrade.BASIC, price));
        System.out.println("GOLD 할인: " + discountService.discount(ClassGrade.GOLD, price));
        System.out.println("DIAMOND 할인: " + discountService.discount(ClassGrade.DIAMOND, price));

        /**
         * 3. 생성 제한 (Safety Check)
         * - 단, 개발자가 실수로 새로운 등급 객체를 만드는 것을 방지해야 함. (직접 new를 해서 임의 ClassGrade 넘기는 것 방지)
         * - ClassGrade의 생성자가 private이므로 new 키워드 사용 시 컴파일 에러 발생.
         */
        // ClassGrade newGrade = new ClassGrade(); // 컴파일 에러: 생성자가 private임

    }
}
