package reviewing.step2.sec05accessmodifier;

public class SpeakerEx {
    public static void main (String[] args) {

        /**
         * 접근 제어자(Access Modifier)와 캡슐화
         *
         * 1. 접근 제어자 종류 (범위 순서: private < default < protected < public)
         *    - private: 내 클래스 안에서만. (데이터 숨기기용)
         *    - default: 같은 패키지 안에서만. (생략하면 자동 적용, 우리 패키지끼리만 공유)
         *    - protected: 같은 패키지 + 상속받은 자식 클래스.
         *    - public: 어디서든 누구나. (기능 공개용)
         *
         * 2. 캡슐화(Encapsulation)란?
         *    - 데이터(속성)와 기능(메서드)을 하나로 묶고, "외부에 꼭 필요한 기능만 노출하고 나머지는 숨기는 것".
         *    - 직접적인 데이터 변경을 방지하는 목적!
         *
         * 3. 실무 규칙 (관례)
         *    - 필드(속성): 무조건 `private`으로 숨긴다.
         *    - 메서드(기능): 외부에서 써야 하면 `public`, 내부에서만 도는 로직이면 `private`.
         *
         * 4. 클래스 레벨 접근 제어자 규칙
         *    - public 클래스는 파일명과 이름이 같아야 하며, 파일당 하나만 존재 가능.
         *    - default 클래스(접근제어자 생략)는 파일 내에 여러 개 존재 가능하지만, 같은 패키지 내에서만 접근 가능.
         */

        Speaker speaker = new Speaker(90);
        speaker.volumeUp();   // 100
        speaker.volumeUp();   // 최대 음량 경고

        // speaker.volume = 200; // private 변수라 접근 불가!
        // -> 덕분에 "음량은 100을 넘을 수 없다"는 스피커의 규칙(무결성)이 지켜짐.

        speaker.showVolume();
    }
}
