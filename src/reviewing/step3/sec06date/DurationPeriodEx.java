package reviewing.step3.sec06date;

import java.time.*;

/**
 * Period와 Duration (시간의 간격/양)
 * 
 * 1. 시간의 개념
 * - 시점 (Point): 특정 시점의 시간(시각) (e.g., 2024-01-01, 12:00)
 * - 간격 (Amount): 시간의 간격 (기간) (e.g., 3일 동안, 30분 간)
 *   -> Period와 Duration은 흐른 시간의 '양(Amount)'이나 '덩어리'를 의미함.
 *
 * 2. 구분
 * - Period: '날짜' 단위의 간격 (년, 월, 일) -> 주로 LocalDate와 활용
 * - Duration: '시간' 단위의 간격 (시, 분, 초, 나노초) -> 주로 LocalTime, Instant와 활용
 *
 * 3. 활용
 * - 날짜/시간 연산: "특정 시점 + (시간 덩어리) = 미래 시점"
 *   (예: 구독 기간 1개월 연장, 로그인 토큰 30분 유효 설정)
 * - 간격 측정: "시작 시점 ~ 종료 시점 사이의 (시간 덩어리) 크기는?"
 *   (예: D-Day 계산, 총 근무 시간 측정, 로직 실행 시간 체크)
 */
public class DurationPeriodEx {

    public static void main(String[] args) {
        /**
         * 1. Period (날짜 간격)
         * - 년(Year), 월(Month), 일(Day) 단위
         */
        System.out.println("--- 1. Period (날짜) ---");

        // 생성 (10일이라는 시간의 양)
        Period tenDays = Period.ofDays(10);
        System.out.println("생성된 기간: " + tenDays); // P10D (Period 10 Days)

        // 계산 (날짜 + 기간)
        LocalDate startDate = LocalDate.of(2030, 1, 1);
        LocalDate plusDate = startDate.plus(tenDays); // 2030-01-01 + 10일
        System.out.println("기준일(" + startDate + ") + 10일 = " + plusDate);

        // 차이 구하기 (D-Day 계산 등에 사용)
        LocalDate endDate = LocalDate.of(2030, 4, 5);
        Period between = Period.between(startDate, endDate);
        System.out.println("두 날짜 사이의 간격: "
                + between.getMonths() + "개월 " + between.getDays() + "일");

        /**
         * 2. Duration (시간 간격)
         * - 시(Hour), 분(Minute), 초(Second), 나노초(Nano) 단위
         */
        System.out.println("\n--- 2. Duration (시간) ---");

        // 생성 (30분이라는 시간의 양)
        Duration thirtyMins = Duration.ofMinutes(30);
        System.out.println("생성된 시간량: " + thirtyMins); // PT30M (Period Time 30 Minutes)

        // 계산 (시간 + 시간량)
        LocalTime startTime = LocalTime.of(1, 0); // 01:00
        LocalTime plusTime = startTime.plus(thirtyMins); // 01:00 + 30분
        System.out.println("기준시(" + startTime + ") + 30분 = " + plusTime);

        // 차이 구하기 (실행 시간 측정 등에 사용)
        LocalTime workStart = LocalTime.of(9, 0);
        LocalTime workEnd = LocalTime.of(10, 30);

        Duration workDuration = Duration.between(workStart, workEnd);

        System.out.println("근무 시간(초): " + workDuration.getSeconds() + "초"); // Duration은 기본적으로 '초'나 '나노초'로 저장됨
        System.out.println("근무 시간(분): " + workDuration.toMinutes() + "분");  // 변환해서 보기 (toHours, toMinutes 등)

    }
}

