package reviewing.step3.sec01object.tostring;

/**
 * [toString() 기본]
 * - 객체의 정보를 문자열로 반환하는 메서드. (주로 디버깅, 로깅용)
 * - `Object` 클래스의 toString 기본 구현: `클래스명@16진수해시코드` (e.g., `java.lang.Object@a09ee92`)
 *   - 이 단계에서는 객체 참조값 정도로 이해 (hashCode는 별도 학습)
 *
 * [System.out.println()과의 관계]
 * - `System.out.println(객체)`를 호출하면, 내부적으로 `객체.toString()`을 실행하여 그 반환값을 출력함.
 * - 따라서 객체를 인자로 넘겨 출력하나, `.toString()`의 문자열을 인자로 넘겨 출력하나 결과는 같음.
 */
public class ToStringEx1 {
    public static void main(String[] args) {
        Object object = new Object();
        String string = object.toString();

        // 1. toString() 반환값 직접 출력
        System.out.println(string);

        // 2. 객체 자체를 출력 (println 내부적으로 toString() 호출)
        System.out.println(object);
    }
}
