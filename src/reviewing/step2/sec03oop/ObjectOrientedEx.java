package reviewing.step2.sec03oop;

public class ObjectOrientedEx {

    /**
     * 객체 지향 프로그래밍 (Object-Oriented Programming)
     *
     * 1. 핵심 개념
     *  - 실제 세계의 사물(Object)을 소프트웨어 세계로 옮겨옴.
     *  - 데이터(속성)와 기능(행동)을 '객체'라는 하나의 단위로 묶음.
     *  - 데이터가 수동적으로 당하는 것이 아니라, 객체가 메서드를 통해 능동적으로 자신의 데이터를 관리함.
     *
     * 2. 캡슐화 (Encapsulation)
     *  - 데이터와 관련 기능을 하나의 클래스(MusicPlayer)에 담는 것.
     *  - 정보 은닉(Information Hiding): 사용하는 쪽(main)에서는 객체 내부가 어떻게 돌아가는지 알 필요가 없음. 그냥 명령어(메서드)만 내리면 됨.
     *
     * 3. 장점
     *  - 높은 응집도(Cohesion): 관련된 기능이 모여 있어 코드를 이해하기 쉬움.
     *  - 낮은 결합도(Coupling): 내부 로직이 바뀌어도, 이를 사용하는 외부 코드(main)는 영향을 받지 않음. (변경에 유연함)
     */
    public static void  main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();

        //음악 플레이어 켜기
        // > 사용자는 musicPlayer 내부 변수가 isOn인지 뭔지 몰라도 됨. 그냥 켜라고 명령만 하면 됨
        musicPlayer.on();

        //음악 플레이어 볼륨 조절
        musicPlayer.upVolume();
        musicPlayer.upVolume();
        musicPlayer.downVolume();

        //음악 플레이어 상태
        musicPlayer.showStatus();

        //음악 플레이어 끄기
        musicPlayer.off();
    }
}
