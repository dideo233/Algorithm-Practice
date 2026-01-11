package reviewing.step3.sec05enum.refactoring;


/**
 * Enum 리팩토링 (DiscountService -> EnumGrade 기능 이관)
 *
 * [1. 데이터 관리: Service의 if문 -> Enum 상수의 필드]
 * - 기존: 등급(EnumGrade)과 할인율 데이터(DiscountService의 discountPercent)가 분리되어 있었음.
 * - 변경: EnumGrade 상수가 `discountPercent` 필드를 직접 가지도록 수정.
 *   -> 등급과 할인율이 한 곳(Enum)에서 묶여 관리됨 (데이터 응집력 향상).
 *   -> 등급이 추가되면 Service의 로직도 수정해야 하는 의존성 해결함.
 *
 * [2. 계산 로직: Service의 연산 -> Enum의 메서드]
 * - 기존: Service가 `grade.getPercent()`로 값을 꺼내(Getter) 외부에서 계산함.
 * - 변경: EnumGrade에 `discount(price)` 메서드를 추가하여 객체가 스스로 계산.
 *   -> 외부(Service)는 값을 처리하는 대신, 내부에서 처리하고 결과만 반환함 (캡슐화).
 *
 * [3. 구조 개선: DiscountService 제거]
 * - 기존: if 분기와 할인율 계산 로직을 리펙토링한 결과, 단순한 계산 위임 역할만 하는 DiscountService가 남음.
 * - 변경: 껍데기만 남은 DiscountService 삭제.
 *   -> 이제 Main에서 `grade.discount(price)`를 바로 호출. (간결화)
 *
 */
public class EnumGradeEx {

    public static void main(String[] args) {
        int price = 10000;

        // 등급이 추가되어도 코드를 수정할 필요 없음 (OCP 준수)
        EnumGrade[] grades = EnumGrade.values();
        for (EnumGrade grade : grades) {
            printDiscount(grade, price);
        }
    }

    private static void printDiscount(EnumGrade grade, int price) {
        // Service 없이 Enum이 스스로 계산(discount)한 결과를 출력
        System.out.println(grade.name() + " 등급 할인 금액: " + grade.discount(price));
    }
}