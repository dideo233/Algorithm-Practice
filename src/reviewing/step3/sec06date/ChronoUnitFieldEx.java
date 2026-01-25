package reviewing.step3.sec06date;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * ChronoUnit(단위)과 ChronoField(필드)
 * - 날짜와 시간을 조회하거나 조작할 때 사용하는 핵심 인터페이스
 * - 단독으로 쓰기보다 Temporal 구현체와 함께 사용
 *
 * 1. ChronoUnit (시간의 단위)
 * - 시간의 크기/단위를 나타냄 (e.g., 년, 월, 일, 시, 분, 초).
 * - 용도: 두 시간 사이의 간격(between) 구하기, 시간 더하기/빼기(plus/minus)에 사용.
 *
 * 2. ChronoField (시간의 필드)
 * - 날짜와 시간을 구성하는 특정 요소 (e.g., "올해의 몇 번째 날인가?", "오전인가 오후인가?").
 * - 용도: 날짜의 특정 부분 값 조회(get), 특정 부분 값 변경(with)에 사용.
 *
 * 3. TemporalAdjusters: 복잡한 날짜 계산 기능 제공 (다음 주 금요일, 이번 달 마지막 날 등)
 */
public class ChronoUnitFieldEx {

    public static void main(String[] args) {

        /**
         * 1. ChronoUnit (단위) 활용
         * - 시간의 차이(between) 계산에 주로 사용
         */
        System.out.println("--- 1. ChronoUnit ---");

        for (ChronoUnit unit : ChronoUnit.values()) {
            System.out.println("unit = " + unit);
        }
        System.out.println("HOURS = " + ChronoUnit.HOURS);
        System.out.println("HOURS.duration(seconds) = " + ChronoUnit.HOURS.getDuration().getSeconds());

        System.out.println("DAYS = " + ChronoUnit.DAYS);
        System.out.println("DAYS.duration(seconds) = " + ChronoUnit.DAYS.getDuration().getSeconds());

        // 시간 차이 계산
        LocalTime t1 = LocalTime.of(1, 10, 0);
        LocalTime t2 = LocalTime.of(1, 20, 0);
        System.out.println("secondsBetween = " + ChronoUnit.SECONDS.between(t1, t2));
        System.out.println("minutesBetween = " + ChronoUnit.MINUTES.between(t1, t2));

        /**
         * 2. ChronoField
         */
        System.out.println("\n--- 2. ChronoField ---");

        for (ChronoField field : ChronoField.values()) {
            System.out.println("field = " + field + ", range = " + field.range());
        }

        System.out.println("MONTH_OF_YEAR.range = " + ChronoField.MONTH_OF_YEAR.range());
        System.out.println("DAY_OF_MONTH.range = " + ChronoField.DAY_OF_MONTH.range());

        /**
         * 3. ChronoField로 날짜/시간 조회
         */
        System.out.println("\n--- 3. ChronoField 특정 날짜/시간 조회 ---");

        // get(TemporalField)으로 특정 필드 조회
        LocalDateTime ldt = LocalDateTime.of(2030,1,1,13,30,59);
        System.out.println("YEAR = " + ldt.get(ChronoField.YEAR));
        System.out.println("MONTH = " + ldt.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("DAY = " + ldt.get(ChronoField.DAY_OF_MONTH));
        System.out.println("HOUR = " + ldt.get(ChronoField.HOUR_OF_DAY));
        System.out.println("MINUTE = " + ldt.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println("SECOND = " + ldt.get(ChronoField.SECOND_OF_MINUTE));

        // 보통은 편의 메서드로 특정 필드 조회
        System.out.println("YEAR (편의) = " + ldt.getYear());

        // 편의 메서드가 없는 경우에만 Field 사용
        System.out.println("MINITE_OF_DAY = " + ldt.get(ChronoField.MINUTE_OF_DAY));
        System.out.println("SECOND_OF_DAY = " + ldt.get(ChronoField.SECOND_OF_DAY));

        /**
         * 4. ChronoUnit으로 날짜/시간 조작
         */
        System.out.println("\n--- 4. ChronoUnit 날짜/시간 조작 ---");

        LocalDateTime base = LocalDateTime.of(2030, 1, 1, 13, 30, 59);
        LocalDateTime plus1 = base.plus(10, ChronoUnit.YEARS); // ChronoUnit으로 조작
        LocalDateTime plus2 = base.plusYears(10); // 편의 메서드 역시 제공됨
        Period period = Period.ofYears(10);
        LocalDateTime plus3 = base.plus(period); // 혹은 period, duration 사용

        System.out.println("plus (ChronoUnit) = " + plus1);
        System.out.println("plus (편의 메서드) = " + plus2);
        System.out.println("plus (Period) = " + plus3);

        /**
         * 5. 유틸리티 메서드
         */
        System.out.println("\n--- 5. 유틸리티 ---");
        // isSupproted() : 특정 ChronoField 필드 지원 유무 확인
        LocalDate now = LocalDate.now();
        if (now.isSupported(ChronoField.SECOND_OF_MINUTE)) {
            System.out.println("SECOND_OF_MINUTE = " + now.get(ChronoField.SECOND_OF_MINUTE));
        }

        // with() : 특정 필드 값 변경
        LocalDateTime changed = base.with(ChronoField.YEAR, 2020);
        System.out.println("원본 = " + base);
        System.out.println("변경 = " + changed);

        /**
         * 6. TemporalAdjusters
         */

        // 다음 주 금요일
        LocalDateTime nextFriday = base.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("다음 금요일 = " + nextFriday);

        // 이번 달 마지막 일요일
        LocalDateTime lastSunday = base.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println("이번 달 마지막 일요일 = " + lastSunday);
    }
}
