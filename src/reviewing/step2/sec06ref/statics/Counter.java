package reviewing.step2.sec06ref.statics;

public class Counter {
    private int count; // 인스턴스 변수 (객체마다 별도 존재)

    public void increase() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
