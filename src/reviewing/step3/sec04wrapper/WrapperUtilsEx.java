package reviewing.step3.sec04wrapper;

/**
 * 래퍼 클래스의 주요 메서드와 성능 고려사항
 *
 * 1. 주요 유틸리티 메서드
 * - 변환: valueOf() -> 래퍼 반환, parseInt() -> 기본형 반환
 * - 비교: compareTo() -> 크다(1), 같다(0), 작다(-1)
 * - 연산: sum(), max(), min() 등 간단한 산술 연산 제공
 *
 * 2. 성능과 메모리 (기본형 vs 래퍼 클래스)
 * - 기본형(Primitive): 데이터 값만 메모리에 저장 (int = 4byte). 가볍고 빠름.
 * - 래퍼(Wrapper): 값뿐만 아니라 객체 메타데이터(헤더 등)를 포함하여 더 무거움 (약 8~16byte 이상).
 * - But: 일반적인 애플리케이션 개발 시에는 미미한 성능 차이임. (10억 번 연산 시 0.3초 vs 1.5초 차이 수준. 1회 연산은 둘 다 빠름!)
 *
 * 3. 최적화 가이드
 * - [상황별 선택]
 *   일반적인 상황: 유지보수성을 위해 래퍼 클래스(객체)를 편하게 사용해도 무방함. (웹 앱 병목은 주로 DB/네트워크임)
 *   특수 상황: CPU 연산이 수십억 번 반복되는 구간에서는 오토 박싱 비용을 줄이기 위해 기본형 사용을 고려.
 * - [핵심 원칙: 선(先) 유지보수, 후(後) 최적화]
 *   유지보수하기 좋은 코드를 먼저 작성하고, 추후 성능 테스트에서 병목 구간이 식별되면 그때 최적화하는 것을 권장함.
 */
public class WrapperUtilsEx {
    public static void main(String[] args) {
        /**
         * 1. 주요 메서드 활용
         */
        // 변환 (String/int -> Wrapper/int)
        Integer i1 = Integer.valueOf(10);        // 숫자 -> 래퍼 객체
        Integer i2 = Integer.valueOf("20");      // 문자열 -> 래퍼 객체
        int intValue = Integer.parseInt("30");   // 문자열 -> 기본형 (자주 씀)

        // 비교 (compareTo)
        int result = i1.compareTo(20); // 10 < 20 이므로 -1 반환
        System.out.println("비교 결과(10 vs 20): " + result);

        // 산술 연산 (static method)
        System.out.println("합(sum): " + Integer.sum(10, 20));
        System.out.println("최소(min): " + Integer.min(10, 20));
        System.out.println("최대(max): " + Integer.max(10, 20));

        /**
         * 2. 성능 비교 (기본형 vs 래퍼 클래스)
         * - 10억 번의 반복 연산을 수행하여 시간 차이 측정
         */
        int iterations = 1_000_000_000;
        long startTime, endTime;

        // 2-1. 기본형(primitive) 연산
        long sumPrimitive = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sumPrimitive += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("기본형(long) 소요 시간: " + (endTime - startTime) + "ms");

        // 2-2. 래퍼 클래스(Wrapper) 연산
        // 문제점: Long은 불변 객체임. += 연산 시마다 새로운 Long 객체를 생성하고(오토 박싱), 기존 값을 버림.
        // 10억 개의 객체를 생성하고 수거(GC)하는 비용 때문에 훨씬 느림.
        Long sumWrapper = 0L;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sumWrapper += i; // 오토 박싱 발생 (기본형 i -> Long 객체)
        }
        endTime = System.currentTimeMillis();
        System.out.println("래퍼 클래스(Long) 소요 시간: " + (endTime - startTime) + "ms");

    }
}
