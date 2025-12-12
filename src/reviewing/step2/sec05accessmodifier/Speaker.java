package reviewing.step2.sec05accessmodifier;

public class Speaker {
    private int volume;

    Speaker(int volume) {
        this.volume = volume;
    }

    void volumeUp() {
        if (volume >= 100) {
            System.out.println("최대 음량입니다. 증가할 수 없습니다.");
            return; //예외 상황이면 함수 즉시 종료
        }

        // else를 쓰지 않고 메인 로직이 바로 나옴 -> 가독성 증가 (검증/실행 로직 분리)
        volume += 10;
        System.out.println("음량을 10 증가합니다.");
    }

    void volumeDown() {
        volume -= 10;
        System.out.println("음량을 10 낮춥니다");
    }

    void showVolume() {
        System.out.println("현재 볼륨 : " + volume);
    }
}


