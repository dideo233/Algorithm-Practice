package reviewing.step3.sec01object;

/**
 * [java.lang 패키지]
 * - 자바 언어의 가장 핵심적인 기본 클래스들을 담고 있는 패키지.
 * - `import` 문 없이 자동으로 포함되므로 생략 가능.
 * - 주요 구성:
 *   - `Object`: 모든 클래스의 최상위 부모.
 *   - `String`: 문자열 클래스.
 *   - `Integer`, `Double`: 기본형을 감싸는 래퍼(Wrapper) 클래스. (기본형을 객체로 제공)
 *   - `System`: 운영체제 및 시스템 관련 기능.
 *
 * [Object 클래스와 상속]
 * - 자바의 모든 클래스는 `Object` 클래스의 자식이다.
 * - 부모가 명시되지 않은 클래스는 컴파일러가 묵시적으로 `extends Object`를 추가한다.
 *
 * [Object가 최상위인 이유]
 * - 공통 기능 제공: 모든 객체가 공통적으로 가져야 할 기능(정보 확인, 비교 등)을 통일성 있게 제공.
 * - 다형성 지원: `Object`는 모든 클래스의 부모이므로, 모든 타입의 객체를 참조(저장)할 수 있음.
 *   -> 서로 다른 타입의 객체를 하나의 배열이나 리스트에 담아야 할 때 `Object` 타입 사용.
 *
 * [Object 클래스 주요 메서드]
 * - `toString()`: 객체의 정보를 문자열로 반환.
 * - `equals()`: 두 객체가 논리적으로 같은지 비교 (동등성).
 * - `getClass()`: 현재 객체의 클래스 정보(메타 데이터)를 반환.
 * - `clone()`: 객체 복사본 생성.
 * - `wait`, `notify`: 멀티쓰레드 환경에서 쓰레드 제어용.
 *
 * [기타]
 * - 묵시적 : 개발자가 코드 작성 안 해도 컴파일러에서 자동 수행되는 것
 * - 명시적 : 개발자가 직접 코드 작성 필요
 */
public class LangObjectEx {
    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();
        child.parentMethod();
        String string = child.toString(); // Parent(또는 Object)로부터 상속받은 메서드 사용 가능
        System.out.println(string);
    }
}
