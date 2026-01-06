package reviewing.step3.sec03string;

/**
 * String 연산 최적화와 StringBuilder 사용 가이드
 *
 * 1. 자바 컴파일러의 자동 최적화
 *    - 리터럴 연산: 컴파일 시점에 자동으로 합쳐짐 (런타임 연산 X).
 *      (e.g., `String str = "A" + "B";` -> `String str = "AB";`)
 *    - 변수 연산: 컴파일러가 최적화를 수행함.
 *      (e.g., `String result = str1 + str2;`)
 *      * Java 8 이하: `new StringBuilder().append(str1).append(str2).toString()`로 변환.
 *      * Java 9 이상: `StringConcatFactory`를 사용하여 더 효율적으로 처리.
 *
 * 2. 자동 최적화의 한계 (반복문)
 *    - 반복문 안에서 문자열을 연결(`+=`)할 경우, 컴파일러가 최적화를 시도하더라도
 *      반복 횟수만큼 객체가 생성되고 버려지는 구조적 한계가 발생함. (e.g., notOptimization())
 *    - 결과: 메모리 낭비와 GC 부하로 성능이 급격히 저하됨.
 *
 * 3. StringBuilder를 직접 사용해야 하는 경우
 *    - 반복문 내에서 문자열을 계속 연결할 때 (필수).
 *    - 조건문(if)을 통해 동적으로 문자열을 조합해야 할 때.
 *    - 복잡한 문자열의 특정 부분만 변경/삭제해야 할 때.
 *    - 매우 긴 대용량 문자열을 다룰 때.
 *
 * 4. StringBuilder vs StringBuffer
 *    - 공통점: 둘 다 가변(Mutable) 객체.
 *    - 차이점:
 *      * StringBuffer: 내부 동기화(Synchronized) 지원. 멀티 스레드 환경에서 안전하나 느림.
 *      * StringBuilder: 동기화 없음. 멀티 스레드에선 위험하나 성능이 가장 빠름 (실무 주력).
 */
public class StringOptimizationEx {
    public static void main(String[] args) {

        // 1. 최적화 실패 사례 (String + 연산)
        // 반복 횟수(10만 번)만큼 객체가 생성됨 -> 약 2~4초 소요 (3340ms)
        notOptimization();

        // 2. 권장 사례 (StringBuilder 사용)
        // 객체 1개만 생성하여 재사용 -> 약 0.005초 소요 (5ms)
        optimization();
    }

    static void notOptimization() {
        long startTime = System.currentTimeMillis();
        String result = "";

        for (int i = 0; i < 100000; i++) {
            result += "Hello Java ";
            // -> result = new StringBuilder().append(result).append("Hello Java ").toString();
            // 컴파일러가 매 반복마다 위 코드로 변환하여 실행함 (즉, 객체 생성도 10만 번 발생)
        }

        long endTime = System.currentTimeMillis();
        System.out.println("time = " + (endTime - startTime) + " ms");
    }


    public static void optimization(){
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            // 하나의 sb 객체에 계속 append 하므로 객체 생성이 1번뿐임
            sb.append("Hello Java ");
        }
        long endTime = System.currentTimeMillis();

        String result = sb.toString(); // 마지막에 String으로 변환
        System.out.println("result = " + result);
        System.out.println("time = " + (endTime - startTime) + " ms");
    }
}
