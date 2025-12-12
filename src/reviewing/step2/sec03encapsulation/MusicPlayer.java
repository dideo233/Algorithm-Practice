package reviewing.step2.sec03encapsulation;

public class MusicPlayer {
    int volume;
    boolean isOn;

    void on() {
        isOn = true;
        System.out.println("음악 플레이오 ON");
    }

    void off() {
        isOn = false;
        System.out.println("음악 플레이오 ON");
    }

    void upVolume() {
        volume++;
        System.out.println("볼륨 업: " + volume);
    }

    void downVolume() {
        volume--;
        System.out.println("볼륨 다운: " + volume);
    }

    void showStatus() {
        System.out.println("음악 플레이어 상태 확인");
        if(isOn) {
            System.out.println("음악 플레이어 ON, 볼륨 : " + volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }
}
