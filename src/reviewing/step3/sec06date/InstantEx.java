package reviewing.step3.sec06date;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * Instant와 에포크 시간(Epoch Time)
 *
 * 1. 에포크 시간 (Epoch Time)
 * - Unix timestamp라고도 하며 컴퓨터 시스템의 시간 표기법
 * - 1970년 1월 1일 00:00:00 UTC부터 현재까지 경과된 시간
 *
 * 2. Instant
 * - '기계 중심'의 시간 (Machine Time) 으로, 에포크 시간을 기준으로 경과한 시간을 초(나노초) 단위로 표현
 * - 초(Seconds) + 나노초(Nanos)만 저장
 *
 * 3 특징
 * - 불변성 & UTC 고정: UTC를 기준으로 하므로 전 세계 어디서나 동일한 시점을 가리킴 (타임존 영향 X)
 * - 용도:
 *   - 서버 로그 기록, 트랜잭션 시간 저장, DB 데이터 교환.
 *   - 서로 다른 타임존 간의 데이터 동기화.
 *   - 실행 시간 측정 (두 시점 간의 차이 계산).
 *   - 랜덤 함수의 시드값처럼 유니크한 값 계산
 *
 * 참고: LocalDateTime, ZonedDateTime을 일반적으로 쓰고, 이건 제시된 상황에서 특수하게 사용할 때 많음
 */
public class InstantEx {

    public static void main(String[] args) {

        /**
         * 1. 생성
         * - Instant는 항상 UTC를 기준으로 생성됨.
         */
        System.out.println("--- 1. 생성 ---");
        Instant now = Instant.now(); // 한국에서 실행해도 UTC 시간(9시간 전)이 나옴
        System.out.println("현재 시간(UTC): " + now);

        /**
         * 2. 변환 (From ZonedDateTime)
         * - 타임존이 있는 시간(ZDT)에서 절대적인 순간(Instant)을 추출.
         * - 주의: LocalDateTime은 타임존 정보가 없어서 Instant로 바로 변환 불가.
         */
        System.out.println("\n--- 2. 변환 ---");
        ZonedDateTime zdt = ZonedDateTime.now();
        Instant from = Instant.from(zdt);
        System.out.println("ZDT -> Instant: " + from);

        /**
         * 3. 에포크 시간으로 생성
         * - 1970-01-01 00:00:00 UTC 기준으로 특정 초가 지난 시점 생성.
         */
        System.out.println("\n--- 3. 에포크 시간 ---");
        Instant epochStart = Instant.ofEpochSecond(0); // 에포크 시작점 (0초)
        System.out.println("에포크 시작(0초): " + epochStart);
        Instant after100s = Instant.ofEpochSecond(100); // 100초 후
        System.out.println("에포크 +100초: " + after100s);

        /**
         * 4. 계산 및 조회
         * - 불변 객체이므로 연산 시 새로운 객체 반환.
         */
        System.out.println("\n--- 4. 계산 및 조회 ---");
        // 계산: 3600초(1시간) 더하기
        Instant later = after100s.plusSeconds(3600);
        System.out.println("100초 시점 + 1시간: " + later);

        // 조회: 에포크 초(long)로 반환 (DB 저장 시 주로 사용되는 값)
        long epochSecond = later.getEpochSecond();
        System.out.println("변환된 에포크 초(long): " + epochSecond);

    }
}
