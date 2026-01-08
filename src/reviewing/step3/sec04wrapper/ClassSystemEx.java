package reviewing.step3.sec04wrapper;

import java.util.Arrays;

/**
 * System 클래스
 * - 운영체제(OS) 및 JVM과 상호작용하기 위한 정적(static) 기능들을 제공하는 클래스.
 * - 객체 생성이 불가능하며, 모든 멤버가 static으로 구성됨.
 * - 맥락: 자바는 JVM 위에서 실행되므로 OS 기능(시간, 입출력 등)에 직접 접근할 수 없음.
 *        System 클래스가 이 둘 사이의 다리 역할을 하여 OS 리소스를 활용할 수 있게 해줌.
 *
 * [주요 기능 요약]
 * 1. 표준 입출력: in(입력), out(출력), err(에러)
 * 2. 시간 측정: currentTimeMillis(현재 시간), nanoTime(정밀 시간 측정)
 * 3. 시스템 정보: getenv(OS 환경변수), getProperties(Java 속성)
 * 4. 유틸리티: arraycopy(고속 배열 복사), exit(프로그램 종료)
 */
public class ClassSystemEx {
    public static void main(String[] args) {

        // 밀리초(ms): 1970.1.1 부터 흐른 시간. 날짜 계산이나 대략적인 시간 측정에 사용
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("밀리초 (Date용): " + currentTimeMillis);

        // 나노초(ns): 임의의 시점부터 흐른 시간. 코드 실행 시간 등 정밀한 성능 측정에 사용
        long currentTimeNano = System.nanoTime();
        System.out.println("나노초 (성능 측정용): " + currentTimeNano);

        // getenv: OS(운영체제)에 설정된 환경 변수 (PATH, JAVA_HOME 등)
        System.out.println("OS 환경 변수(Path): " + System.getenv("PATH"));

        // getProperties: Java JVM이 시작될 때 설정된 속성 (자바 버전, OS 종류, 파일 인코딩 등)
        System.out.println("property(Java 버전): " + System.getProperty("java.version"));
        System.out.println("property(파일 인코딩): " + System.getProperty("file.encoding"));

        // 배열 고속 복사 (Array Copy)
        // - for보다 빠른 이유 : JVM이 아닌 OS(운영체제) 레벨에서 메모리를 통째로 복사하기 때문.
        // - 문법: (원본, 원본시작위치, 타겟, 타겟시작위치, 복사개수)
        char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
        char[] copiedArray = new char[5];
        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);

        System.out.println("복사본 출력: " + Arrays.toString(copiedArray));

        // 프로그램 종료 (0: 정상 종료, 0 이외: 에러로 인한 비정상 종료)
        // - 주의: 웹 서버 등에서 사용하면 서버 전체가 꺼지므로 사용에 매우 주의해야 함.
        System.exit(0);
    }
}
