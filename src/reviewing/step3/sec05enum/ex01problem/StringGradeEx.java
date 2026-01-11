package reviewing.step3.sec05enum.ex01problem;

/**
 * 문자열 상수의 한계와 타입 안전 열거형 패턴의 등장 배경
 *
 * 1. 문자열 리터럴 (String Literal) 직접 사용
 * - 타입 안정성 부족: 오타가 발생하기 쉬워, "GOLD", "gold", " Gold" 등 입력 형식이 제각각일 수 있음.
 * - 컴파일 오류 감지 불가: 오타("DIAMONDD")가 있어도 String 문법상 문제가 없으므로, 실행해봐야 버그를 알 수 있음.
 *
 * 2. 문자열 상수 (String Constant) 사용
 * - 개선점: 변수명을 통해 값을 전달하므로 오타가 줄어들고 코드가 명확해짐.
 * - 한계(Limit): 근본적으로 메서드의 파라미터 타입이 `String`임.
 *   -> 오타를 방지할 수 있지만, 개발자가 상수를 무시하고 `discount("VIP")` 처럼 엉뚱한 문자열을 직접 넣어도 막을 방법이 없음.
 *   -> 즉, '허용된 값'만 들어오도록 강제할 수 없음.
 *
 * 3. Enum (Type-Safe Enum Pattern)
 * - 결론: 정해진 항목(BASIC, GOLD, DIAMOND)이 아니면 아예 컴파일조차 안 되도록 막아야 한다.
 * - 이를 위해 class(타입) 자체를 제한하는 Enum이 등장함.
 *
 * [용어]
 * - 타입안전성: 정의된 타입의 값만 사용하도록 강제하는 것
 */
public class StringGradeEx {

    public static void main(String[] args) {

        int price = 10000;
        DiscountServiceWithProblem discountService = new DiscountServiceWithProblem();

        /*
         * 1. 문자열 리터럴 사용의 문제점
         * - 오타와 형식 불일치에 매우 취약함
         */
        System.out.println("--- 1. 문자열 리터럴 사용 (위험) ---");
        System.out.println("BASIC: " + discountService.discountNoEnum("BASIC", price));
        System.out.println("오타 발생(DIOMODD): " + discountService.discountNoEnum("DIOMODD", price)); // 할인 X (런타임 버그)
        System.out.println("소문자 입력(gold): " + discountService.discountNoEnum("gold", price));    // 할인 X (데이터 일관성 깨짐)

        /*
         * 2. 문자열 상수의 한계
         * - 상수를 써서 안전해 보이지만, 여전히 아무 문자열이나 대입 가능함
         */
        System.out.println("\n--- 2. 문자열 상수 사용 (한계 존재) ---");
        // 상수를 사용하면 오타는 방지됨
        System.out.println("GOLD (상수): " + discountService.discountConstant(StringGrade.GOLD, price));

        // 하지만, 상수를 안 쓰고 엉뚱한 값을 넣어도 컴파일 에러가 안 남 (치명적)
        System.out.println("존재하지 않는 VIP 등급 직접 입력: " + discountService.discountConstant("VIP", price));
    }
}
