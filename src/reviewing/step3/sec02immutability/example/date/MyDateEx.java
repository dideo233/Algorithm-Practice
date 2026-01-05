package reviewing.step3.sec02immutability.example.date;

public class MyDateEx {
    public static void main(String[] args) {
        // 가변 객체 - 참조 공유 시 함께 변경됨
        MyDate date1 = new MyDate(2024, 1, 1);
        MyDate date2 = date1;

        date1.setYear(2025);
        System.out.println("date1 = " + date1);  // 2025 (변경됨)
        System.out.println("date2 = " + date2);  // 2025 (함께 변경됨!)

        // 불변 객체 - 새 객체 생성, 기존 참조는 유지
        ImmutableMyDate immutableDate1 = new ImmutableMyDate(2024, 1, 1);
        ImmutableMyDate immutableDate2 = immutableDate1;

        immutableDate1 = immutableDate1.withYear(2025);  // 새 객체 생성
        System.out.println("immutableDate1 = " + immutableDate1);  // 2025 (새 객체)
        System.out.println("immutableDate2 = " + immutableDate2);  // 2024 (원본 유지)

        // 참고: 불변 객체는 with()로 시작하는 메서드로 새 객체를 반환하는 것이 관례
    }
}
