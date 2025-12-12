package reviewing.step2.sec06ref.statics;

public class StaticData {
    private String name;
    private static int count; // 클래스(static) 변수

    public StaticData(String name) {
        this.name = name;
        count++; // 객체 생성 시 공용 변수 증가
    }

    public static int getCount() {
        return count;
    }
}
