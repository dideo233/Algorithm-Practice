package reviewing.step3.sec06date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/***
 * LocalDate, LocalTime, LocalDatTime
 * - 가장 기본이 되는 날짜 및 시간 클래스
 * - 세계 시간대를 고려하지 않고, 특정 지역대의 시간만 고려할 때 사용
 */
public class LocalDateEx {

    public static void main(String[] args) {
        // 1. LocalDate
        //  .now() : 현재 시간 기준 
        //  . on() : 지정 시간 기준
        LocalDate nowDate = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2013, 11, 21);
        System.out.println("오늘 날짜 = " + nowDate);
        System.out.println("지정 날짜 = " + ofDate);

        // 계산 (불변)
        ofDate = ofDate.plusDays(10);
        System.out.println("지정 날짜 + 10 = " + ofDate);

        LocalTime nowTime = LocalTime.now();
        LocalTime ofTime = LocalTime.of(8, 10, 1);

        System.out.println("현재 시간 = " + nowTime);
        System.out.println("지정 시간 = " + ofTime);

        // 2. LocalTime
        // 계산 (불변)
        LocalTime ofTimePlus = ofTime.plusSeconds(30);
        System.out.println("지정 시간 + 10 = " + ofTimePlus);

        // 3. LocalDateTime
        LocalDateTime nowDt = LocalDateTime.now();
        LocalDateTime ofDt = LocalDateTime.of(2013, 11, 21, 8, 10, 1);
        System.out.println("현재 날짜 시간 = " + nowDt);
        System.out.println("지정 날짜 시간 = " + ofDt);

        // 날짜와 시간 분리
        LocalDate separatedDate = ofDt.toLocalDate();
        LocalTime separatedTime = ofDt.toLocalTime();
        System.out.println("분리된 날짜 = " + separatedDate);
        System.out.println("분리된 시간 = " + separatedTime);

        // 날짜와 시간 합체
        LocalDateTime mergedTime = LocalDateTime.of(separatedDate, separatedTime);
        System.out.println("합친 날짜 시간 = " + mergedTime);

        // 계산(불변)
        LocalDateTime ofDtPlus = ofDt.plusDays(1000);
        System.out.println("지정 날짜 시간 + 1000d = " + ofDtPlus);

        LocalDateTime ofDtPlus1Year = ofDt.plusYears(1);
        System.out.println("지정 날짜 시간 + 1y = " + ofDtPlus1Year);

        // 비교
        // toEqual : 타임존 무관하게 시간이 일치하면 true
        // equals : 객체 타입, 타임존 등 내부 데이터의 구성 요소 동일해야 true (좀 더 타이트한 조건)
        System.out.println("현재 날짜 시간이 지정 날짜보다 이전인가? " + nowDt.isBefore(ofDt));
        System.out.println("현재 날짜 시간이 지정 날짜보다 이후인가? " + nowDt.isAfter(ofDt));
        System.out.println("현재 날짜 시간이 지정 날짜와 동일한가? " + nowDt.isEqual(ofDt));
    }
}
