package reviewing.step3.sec05enum.ex03enumeration;

/**
 * Java Enum(열거형)
 * - 정의: 서로 연관된 상수들의 집합을 '클래스'로 정의한 것.
 * - 특징:
 *   1. '타입 안전 열거형 패턴'을 언어 차원에서 지원 (코드가 매우 간결해짐).
 *   2. 모든 enum은 암묵적으로 java.lang.Enum을 상속하며, 다른 클래스를 상속할 수 없음.
 *   3. 선언된 각 enum 상수는 컴파일러에 의해 public static final 필드로 생성된다.
 * - 문법:
 *   1. `class` 대신 `enum` 키워드 사용.
 *   2. 일반 클래스처럼 필드, 메서드, 생성자(private)를 가질 수 있음.
 *   3. 추상 메서드를 선언하여 각 상수별로 다르게 동작하도록 구현 가능. (심화 내용)
 * - 장점: 타임 안정성 향상, 간결성 및 일관성, 확장성 등
 */
public class EnumGradeEx {

    public static void main(String[] args) {
        /**
         * - 열거형은 직접 구현한 '타입 안전 열거형 패턴'과 동일하게 동작함
         * - 기타: enum은 switch문에도 쓸 수 있음
         */
        int price = 10000;
        DiscountService discountService = new DiscountService();
        System.out.println("--- 1. 할인 계산 ---");
        System.out.println("BASIC 할인: " + discountService.discount(EnumGrade.BASIC, price));
        System.out.println("GOLD 할인: " + discountService.discount(EnumGrade.GOLD, price));
        System.out.println("DIAMOND 할인: " + discountService.discount(EnumGrade.DIAMOND, price));

        System.out.println("\n--- 2. 참조값 확인 ---");
        System.out.println("ref BASIC: " + refValue(EnumGrade.BASIC));
        System.out.println("ref GOLD: " + refValue(EnumGrade.GOLD));
        System.out.println("ref DIAMOND: " + refValue(EnumGrade.DIAMOND));
    }

    // Enum의 실제 참조값(주소)을 16진수로 확인하기 위한 헬퍼 메서드
    public static String refValue(Object grade) {
        return Integer.toHexString(System.identityHashCode(grade));
    }
}
