package reviewing.step2.sec05accessmodifier.example;

public class MaxCounter {
    private int count = 0;
    private int max;

    // 생성자를 통해 최대값을 지정 (외부에서 설정 주입)
    public MaxCounter(int max) {
        this.max = max;
    }

    public void increase() {
        // 검증 로직. 카운트가 최대값 이상이면 증가시키지 않고 종료
        if (count >= max) {
            System.out.println("최대값 " + max + "을 초과할 수 없습니다.");
            return;
        }
        // 실행 로직
        count++;
        System.out.println("카운트: " + count);
    }

    public int getCount() {
        return count;
    }
}
