package reviewing.step3.sec04wrapper;

/**
 * 1. Java의 래퍼 클래스 (Wrapper Class) 정의
 * - 기본형(Primitive Type)을 객체로 다루기 위해 사용하는 클래스 (int -> Integer).
 *
 * 2. 주요 개념
 * - 박싱(Boxing) & 언박싱(Unboxing): 기본형 <-> 래퍼 클래스 간의 변환.
 * - 오토 박싱(Auto-boxing): 자바 컴파일러가 변환 과정을 자동으로 처리해주는 기능 (Java 5+).
 */
public class WrapperClassEx {
    public static void main(String[] args) {
        /**
         * 1. 래퍼 클래스 생성 (권장 vs 비권장)
         */
        Integer newInteger = new Integer(10);     // [비권장] 무조건 새 객체 생성 (Java 9부터 Deprecated)
        Integer cachedInteger = Integer.valueOf(10); // [권장] 내부 캐시(-128~127)를 활용하여 성능 최적화.

        System.out.println("newInteger = " + newInteger);
        System.out.println("cachedInteger = " + cachedInteger);

        /**
         * 2. 래퍼 클래스 비교
         * - 래퍼 클래스는 '객체'이므로 == 연산자는 '참조값(주소)'을 비교함.
         * - 따라서 값의 동등성을 비교하려면 반드시 .equals()를 사용해야 함.
         */
        // new로 만들면 무조건 다른 주소
        System.out.println("\n주소 비교 (==): " + (newInteger == cachedInteger)); // false
        // equals는 내부 값을 비교
        System.out.println("값 비교 (equals): " + (newInteger.equals(cachedInteger))); // true

        /**
         * 3. 수동 박싱 & 언박싱 (Manual)
         * - 과거(Java 5 이전)에는 개발자가 직접 변환 코드를 작성해야 했음.
         */
        int primitiveValue = 20;

        // 박싱: 기본형 -> 래퍼 (valueOf)
        Integer manualBoxed = Integer.valueOf(primitiveValue);
        // 언박싱: 래퍼 -> 기본형 (intValue)
        int manualUnboxed = manualBoxed.intValue();

        System.out.println("\n박싱 결과: " + manualBoxed);
        System.out.println("언박싱 결과: " + manualUnboxed);

        /**
         * 4. 오토 박싱 & 언박싱 (Auto)
         * - 컴파일러가 컴파일 단계에서 valueOf()와 intValue()를 자동으로 추가해줌.
         * - 개발자는 마치 기본형을 쓰듯이 편하게 코딩 가능.
         */
        // 오토 박싱 (int -> Integer)
        Integer autoBoxed = 30; // 컴파일러가 Integer.valueOf(30)으로 변환

        // 오토 언박싱 (Integer -> int)
        int autoUnboxed = autoBoxed; // 컴파일러가 autoBoxed.intValue()로 변환
        System.out.println("\n오토 박싱 결과: " + autoBoxed);
        System.out.println("언박싱 결과: " + autoUnboxed);
    }
}
