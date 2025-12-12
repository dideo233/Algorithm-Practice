package reviewing.step2.sec06ref.memory;

import reviewing.step2.sec06ref.statics.Counter; // 패키지 이동에 따른 import

public class Data {
    private String name;
    private int count;

    public Data(String name) {
        this.name = name;
        this.count++;
    }

    public Data(int count) {
        this.count = count;
    }

    // Counter 객체와 협력하는 생성자
    public Data(String name, Counter counter) {
        this.name = name;
        counter.increase();
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}