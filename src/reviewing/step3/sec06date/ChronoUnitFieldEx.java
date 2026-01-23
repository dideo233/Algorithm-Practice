package reviewing.step3.sec06date;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class ChronoUnitFieldEx {

    public static void main(String[] args) {

        // 1. ChronoUnit
        ChronoUnit[] units = ChronoUnit.values();
        for (ChronoUnit unit : units) {
            System.out.println("value = " + unit.name());
        }
        System.out.println("HOURS = " + ChronoUnit.HOURS);
        System.out.println("HOURES.duration = " + ChronoUnit.HOURS.getDuration().getSeconds());
        System.out.println("DAYS = " + ChronoUnit.DAYS);
        System.out.println("DAYS.duration = " + ChronoUnit.DAYS.getDuration().getSeconds());

        // 차이 구하기
        LocalTime lt1 = LocalTime.of(1, 10, 0);
        LocalTime lt2 = LocalTime.of(1, 20, 0);

        long secondsBetween = ChronoUnit.SECONDS.between(lt1, lt2);
        long minutesBetween = ChronoUnit.MINUTES.between(lt1, lt2);
        System.out.println("secondsBetween = " + secondsBetween);
        System.out.println("minutesBetween = " + minutesBetween);

        // 2. ChronoUnit
        ChronoField[] fields = ChronoField.values();
        for (ChronoField field : fields) {
            System.out.println("field = " + field.name() + ", range = " + field.range());
        }

        System.out.println("MONTH_OF_YEAR.range() = " + ChronoField.MONTH_OF_YEAR.range());
        System.out.println("DAY_OF_MONTH.range() = " + ChronoField.DAY_OF_MONTH.range());

        // > 단독으로 쓰기 보다 날짜와 시간을 조회하거나 조작할 때 사용
    }
}
