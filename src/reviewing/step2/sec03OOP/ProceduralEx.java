package reviewing.step2.sec03OOP;

public class ProceduralEx {

    /**
     * 절차 지향 프로그래밍 (Procedural Programming)
     *
     * 1. 핵심 개념
     *  - '무엇을' 할지보다 '어떻게(순서)' 할지에 초점을 맞춤.
     *  - 데이터(Data)와 기능(Method)이 분리되어 있음.
     *  - 데이터는 그저 값만 담고 있는 수동적인 존재이고, 외부의 메서드가 이 데이터를 가져와서 처리함.
     *
     * 2. 예시 설명
     *  - MusicPlayerData: 데이터만 덩그러니 있음 (값 보관함).
     *  - main / static methods: 데이터를 이리저리 굴리는 기능들.
     *
     * 3. 한계 (절차 지향의 문제점)
     *  - 유지보수의 어려움: 데이터 구조(MusicPlayerData)가 바뀌면, 그 데이터를 쓰는 모든 메서드(on, off, upVolume...)를 다 찾아서 고쳐야 함.
     *  - 데이터 무결성 위협: 데이터가 외부에 노출되어 있어, 어디서든(main 등) 데이터를 잘못 조작할 위험이 큼.
     */
    public static void main (String[] args) {
        MusicPlayerData data = new MusicPlayerData();

        //음악 플레이어 켜기
        on(data);
        
        //음악 플레이어 볼륨 조절
        upVolume(data);
        upVolume(data);
        downVolume(data);

        //음악 플레이어 상태
        showStatus(data);

        //음악 플레이어 끄기
        off(data);
    }

    static void on(MusicPlayerData data) {
        data.isOn = true;
        System.out.println("음악 플레이오 ON");
    }

    static void off(MusicPlayerData data) {
        data.isOn = false;
        System.out.println("음악 플레이오 ON");
    }

    static void upVolume(MusicPlayerData data) {
        data.volume++;
        System.out.println("볼륨 업: " + data.volume);
    }

    static void downVolume(MusicPlayerData data) {
        data.volume--;
        System.out.println("볼륨 다운: " + data.volume);
    }

    static void showStatus(MusicPlayerData data) {
        System.out.println("음악 플레이어 상태 확인");
        if(data.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨 : " + data.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }

}
