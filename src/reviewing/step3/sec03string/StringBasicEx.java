package reviewing.step3.sec03string;

/**
 * [Java의 String 클래스 정리]
 * - char와 String의 차이
 * - 리터럴 방식("") vs 객체 방식(new)의 차이 (String Constant Pool)
 * - 문자열의 병합과 비교 (== vs equals)
 */
public class StringBasicEx {
    public static void main(String[] args) {

        /**
         * 1. char 배열 vs String
         * - char[]: 문자를 하나씩 다루기 불편함.
         * - String: char[]을 내부에 감추고, 문자열을 다루기 위한 편리한 기능(메서드)들을 제공하는 클래스.
         *   (참고: Java 9부터는 메모리 효율을 위해 내부적으로 char[](2byte) 대신 byte[](1byte) + 인코딩 플래그를 사용함)
         */
        char[] charArr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str = "hello";
        System.out.println(str);
        System.out.println("char[] 출력: " + charArr);
        System.out.println("String 출력: " + str);

        /**
         * 2. String 생성 방식 (리터럴 vs new)
         * - 리터럴(""): String Pool(힙 영역 내 특수 공간)을 사용하여 메모리 효율 최적화.
         * - new String(): 무조건 힙 영역에 새로운 객체를 생성. (메모리 낭비 가능성 있음)
         */
        String literalStr = "hello";
        String objectStr = new String("hello");
        System.out.println("리터럴 방식: " + literalStr);
        System.out.println("객체 방식(new): " + objectStr);

        /**
         * 3. 문자열 병합 (Concatenation)
         * - 원칙: 참조형끼리의 연산은 불가능하므로 `.concat()` 메서드를 써야 함.
         * - 예외: String은 너무 자주 쓰이므로, 자바가 편의상 `+` 연산자를 지원해줌.
         */
        String s1 = "Hello";
        String s2 = "Java";
        String resultConcat = s1.concat(s2); // 정석 방법
        String resultPlus = s1 + s2;         // 편의상 허용된 방법 (실무에서 주로 사용)
        System.out.println("concat() 메서드: " + resultConcat);
        System.out.println("+ 연산자: " + resultPlus);

        /**
         * 4. 문자열 비교
         * - 동일성(Identity, ==): 참조값(주소)이 같은가?
         * - 동등성(Equality, equals): 내용(문자열 자체)이 같은가?
         */
        // 4-1. 객체 방식 (new) 비교
        String newStr1 = new String("Hello");
        String newStr2 = new String("Hello");
        // 서로 다른 주소에 생성되므로 주소 비교(==)는 false
        System.out.println("new String() 주소 비교(==): " + (newStr1 == newStr2)); // false
        // 내용은 같으므로 내용 비교(equals)는 true
        System.out.println("new String() 내용 비교(equals): " + (newStr1.equals(newStr2))); // true

        // 4-2. 리터럴 방식("") 비교 - String Constant Pool
        String litStr1 = "hello";
        String litStr2 = "hello";
        // 자바가 String Pool에서 이미 만들어진 "hello"를 재사용하게 하므로 주소가 같음
        System.out.println("리터럴 주소 비교(==): " + (litStr1 == litStr2)); // true (최적화 덕분)
        System.out.println("리터럴 내용 비교(equals): " + (litStr1.equals(litStr2))); // true

        // 4-3. 실무에서의 문자열 비교
        // 리터럴인지 new인지 개발자가 매번 따질 수 없으므로, 문자열 비교는 무조건 equals()를 써야 함.
        boolean result1 = isSame(litStr1, litStr2); // true (리터럴끼리라 운 좋게 통과)
        boolean result2 = isSame(newStr1, newStr2); // false (내용은 같은데 false가 나옴 -> 버그 발생)
        System.out.println("isSame(리터럴, 리터럴): " + result1);
        System.out.println("isSame(new, new): " + result2 + " -> 버그 발생!");

        /*
         * [참고] String Constant Pool (문자열 풀) 심화
         * 1. 개념: 메모리 효율성과 성능 최적화를 위해 문자열 리터럴을 모아두는 힙(Heap) 영역 내 특수 공간.
         * 2. 동작 원리:
         *    - 리터럴("hello") 선언 시, JVM은 먼저 풀(Pool)을 탐색함 (Hash 알고리즘 사용).
         *    - 존재 O: 새로 생성하지 않고, 기존 인스턴스의 참조값(x001)을 그대로 반환.
         *    - 존재 X: 풀에 새 인스턴스를 생성하고, 그 참조값을 반환. (이후 해당 리터럴 선언 시 재사용)
         * 3. 결론: 따라서 `litStr1`과 `litStr2`는 변수명은 다르지만, 내부적으로는 완전히 같은 주소(x001)를 가리킴.
         */
    }

    // 문자열을 == 로 비교하면, 파라미터로 들어오는 객체 생성 방식에 따라 결과가 달라짐
    private static boolean isSame(String str1, String str2) {
        return str1 == str2;
    }

}
