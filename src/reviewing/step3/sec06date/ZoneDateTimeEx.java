package reviewing.step3.sec06date;

import java.time.*;

/**
 * 타임존(Time Zone)이 포함된 날짜와 시간
 *
 * 1. ZonedDateTime
 *    - LocalDateTime + ZoneId (타임존 규칙 + 일광 절약 시간(DST)포함) + ZoneOffset (UTC와의 시차)
 *    - 특정 국가/지역의 시간을 사용자에게 보여주거나 스케줄링할 때 사용. (e.g., 기념일 등)
 *
 * 2. OffsetDateTime
 *    - LocalDateTime + ZoneOffset (UTC와의 단순 시차만 포함)
 *    - 복잡한 타임존 규칙 없이 절대적인 시간 차이만 기록할 때 사용.
 *    - 주로 DB 저장, 로그 기록, 네트워크 통신 등 시스템 간 데이터 교환 표준으로 사용.
 *
 * [참고] 글로벌 서비스 시 주로 쓰는 클래스로, 그 외에는 거의 안 씀
 */
public class ZoneDateTimeEx {

    public static void main(String[] args) {

        /**
         * 1. ZoneId (타임존 정보)
         */
        System.out.println("--- 1. ZoneId ---");
        // 시스템 기본 타임존 확인
        ZoneId systemZone = ZoneId.systemDefault();
        System.out.println("시스템 기본 ZoneId: " + systemZone);

        // 특정 타임존 지정
        ZoneId seoulZone = ZoneId.of("Asia/Seoul");
        System.out.println("서울 ZoneId: " + seoulZone);
        // (참고) ZoneId.getAvailableZoneIds(): 사용 가능한 모든 타임존 ID 목록 반환

        /**
         * 2. ZonedDateTime
         * - 날짜, 시간, 타임존, 시차(Offset) 정보를 모두 가짐
         */
        System.out.println("\n--- 2. ZonedDateTime ---");

        // 현재 시간 (타임존 포함)
        ZonedDateTime nowZdt = ZonedDateTime.now();
        System.out.println("현재 ZDT: " + nowZdt);

        // 생성: LocalDateTime + ZoneId
        LocalDateTime ldt = LocalDateTime.of(2030, 1, 1, 13, 30, 50);
        ZonedDateTime seoulZdt = ZonedDateTime.of(ldt, seoulZone);
        System.out.println("지정 ZDT (서울): " + seoulZdt);

        // 타임존 변환 (같은 시각, 다른 지역)
        // withZoneSameInstant: "지금 서울이 13:30일 때, UTC(영국)는 몇 시인가?"
        ZonedDateTime utcZdt = seoulZdt.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("서울 시간에서 영국 시간 구하기: " + utcZdt);

        /**
         * 3. OffsetDateTime
         * - 타임존 규칙(DST 등)을 뺀 가벼운 버전. 오직 UTC와의 시차만 가짐.
         */
        System.out.println("\n--- 3. OffsetDateTime ---");

        OffsetDateTime nowOdt = OffsetDateTime.now();
        System.out.println("현재 ODT: " + nowOdt);

        // 생성: LocalDateTime + ZoneOffset
        ZoneOffset offset = ZoneOffset.of("+01:00");
        OffsetDateTime odt = OffsetDateTime.of(ldt, offset);
        System.out.println("지정 ODT (UTC+01:00): " + odt);
    }
}
