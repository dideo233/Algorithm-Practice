package reviewing.step3.sec05enum.ex03enumeration;

import java.util.Arrays;

/**
 * 1. 주요 메서드
 * - values(): 모든 상수를 배열로 반환.
 * - valueOf(String): 문자열을 Enum 상수로 변환.
 * - name(): 상수의 이름을 문자열로 반환.
 * - ordinal(): 상수의 순서(index)를 정수로 반환 (0부터 시작).
 * - toString(): 상수의 문자열 표현 반환 (기본은 name()과 같으나 오버라이딩 가능).
 *
 * [주의] ordinal() 사용 지양
 * - 이유: Enum 상수의 선언 순서가 바뀌면 ordinal 값도 변하기 때문.
 * - 시나리오 (DB 저장 시):
 *   1. BASIC(0), GOLD(1), DIAMOND(2) -> DB에 1(GOLD) 저장됨.
 *   2. 중간에 SILVER 추가 -> BASIC(0), SILVER(1), GOLD(2)...
 *   3. DB의 1은 원래 GOLD였는데, 애플리케이션은 이제 SILVER로 읽음. -> 데이터 무결성 붕괴.
 * - 결론: DB 저장 시에는 ordinal 대신 name(문자열)을 저장하는 것이 안전함.
 */
public class EnumMethodsEx {
    public static void main(String[] args) {

        /**
         * 1. 모든 상수 조회 (values)
         * - Enum에 정의된 순서대로 배열에 담겨 반환됨.
         */
        System.out.println("--- 1. values() ---");
        EnumGrade[] values = EnumGrade.values();
        System.out.println("모든 상수 배열: " + Arrays.toString(values));

        /**
         * 2. 정보 조회 (name, ordinal)
         * - 순회하며 이름과 순서를 확인.
         */
        System.out.println("\n--- 2. name() & ordinal() ---");
        for (EnumGrade grade : values) {
            System.out.println("name=" + grade.name() + ", ordinal=" + grade.ordinal());
        }

        /**
         * 3. 문자열 변환 (valueOf)
         * - String -> Enum 변환.
         * - 일치하는 상수가 없으면 `IllegalArgumentException` 발생.
         */
        System.out.println("\n--- 3. valueOf() ---");
        String input = "GOLD";
        EnumGrade gold = EnumGrade.valueOf(input);

        System.out.println("입력받은 문자열(String): " + input);
        System.out.println("변환된 Enum 상수: " + gold); // toString() 호출됨
        System.out.println("변환된 Enum 타입: " + gold.getClass());
    }
}
