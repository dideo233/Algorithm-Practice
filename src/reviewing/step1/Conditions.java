package reviewing.step1;

/**
 * Java의 주요 조건문(Conditional Statements) 정리
 * - if, else if, else: 가장 기본적인 조건 분기
 * - switch: 특정 변수의 값에 따른 다중 분기
 * - 삼항 연산자: 간단한 분기를 한 줄로 표현
 */
public class Conditions {

    public static void main(String[] args) {

        /**
         * 1. if-else 문: 조건이 참(true)인지 거짓(false)인지에 따라 다른 코드를 실행
         * 가장 기본적이고 널리 사용되는 조건문.
         */
        System.out.println("--- 1. if-else 문 ---");
        int age = 20;

        if (age >= 18) {
            System.out.println("age = " + age + " -> 성인입니다.");
        } else {
            System.out.println("age = " + age + " -> 미성년자입니다.");
        }


        /**
         * 2. else if 문: 여러 개의 조건을 순차적으로 검사
         * if 조건이 거짓일 때, 또 다른 조건을 검사하고 싶을 때 사용.
         * 여러 조건 중 하나만 만족하면, 해당 블록 실행 후 전체 if-else if 구조를 빠져나감.
         */
        System.out.println("\n--- 2. else if 문 ---");
        int personAge = 15;

        // 하나의 변수(personAge)를 기준으로 여러 조건을 검사하므로, else if가 적합함.
        if (personAge <= 7) {
            System.out.println("나이 " + personAge + "세 -> 미취학 아동입니다.");
        } else if (personAge <= 13) {
            System.out.println("나이 " + personAge + "세 -> 초등학생입니다.");
        } else if (personAge <= 16) {
            System.out.println("나이 " + personAge + "세 -> 중학생입니다.");
        } else if (personAge <= 19) {
            System.out.println("나이 " + personAge + "세 -> 고등학생입니다.");
        } else {
            System.out.println("나이 " + personAge + "세 -> 성인입니다.");
        }

        // 단, 서로 독립적인 조건은 else if를 사용하면 안 됨
        // 만약 else if로 묶었다면, 첫 번째 조건이 참일 경우 두 번째 조건은 검사조차 하지 않았을 것.
        System.out.println("\n[주의] 서로 독립적인 조건은 별개의 if문으로 작성");
        int price = 12000;
        int customerAge = 10;
        int totalDiscount = 0;

        if (price >= 10000) {
            totalDiscount += 1000;
            System.out.println("10,000원 이상 구매 -> 1,000원 할인 적용");
        }
        if (customerAge <= 10) {
            totalDiscount += 1000;
            System.out.println("어린이 고객 -> 1,000원 추가 할인 적용");
        }
        System.out.println("=> 최종 할인 금액: " + totalDiscount + "원");


        /**
         * 3. switch 문: 특정 변수의 값이 뭐냐에 따라 코드를 실행
         * if-else if가 복잡하게 이어지는 코드를 더 깔끔하게 만들 수 있음.
         * 범위 비교(>, <)는 불가능하고, 특정 값과 일치하는지만 비교 가능.
         */
        System.out.println("\n--- 3. switch 문 ---");
        int memberGrade = 2;
        int coupon;

        // 전통적인 switch 문
        switch (memberGrade) {
            case 1:
                coupon = 1000;
                break; // break: 여기서 switch문을 탈출하라는 명령. 없으면 다음 case가 계속 실행됨.
            case 2:
                coupon = 2000;
                break;
            case 3:
                coupon = 3000;
                break;
            default: // if문의 else와 같은 역할
                coupon = 500;
                break; // default의 break는 필수는 아니지만, 코드 일관성을 위해 써주는 것이 좋음.
        }
        System.out.println("전통 switch -> 등급 " + memberGrade + "의 쿠폰: " + coupon + "원");

        // break를 의도적으로 생략하여 여러 case를 묶을 수 있음.
        switch (memberGrade) {
            case 1:
                coupon = 1000;
                break;
            case 2: // grade가 2일 때 break가 없으므로
            case 3: // grade가 3인 것처럼 아래 코드가 실행됨
                coupon = 3000;
                break;
            default:
                coupon = 500;
        }
        System.out.println("break 응용 -> 등급 " + memberGrade + "의 쿠폰 (2,3등급 통합): " + coupon + "원");

        // 새로운 switch 문 (Java 14 이상)
        // 코드가 훨씬 간결해지고, break를 신경 쓸 필요가 없음.
        // '->' 우측의 값을 자동으로 반환(return)해줌.
        int modernCoupon = switch (memberGrade) {
            case 1 -> 1000;
            case 2 -> 2000;
            case 3 -> 3000;
            default -> 500;
        };
        System.out.println("새로운 switch -> 등급 " + memberGrade + "의 쿠폰: " + modernCoupon + "원");


        /**
         * 4. 삼항 연산자 (Ternary Operator)
         * 간단한 if-else 문을 딱 한 줄로 줄여 쓸 수 있는 유용한 기술.
         * (조건식) ? (참일 때의 값) : (거짓일 때의 값)
         */
        System.out.println("\n--- 4. 삼항 연산자 ---");
        int userAge = 18;
        String status = (userAge >= 18) ? "성인" : "미성년자";
        System.out.println("나이가 " + userAge + "세인 회원의 상태: " + status);

        int number = 2;
        String type = (number % 2 == 0) ? "짝수" : "홀수";
        System.out.println("숫자 " + number + "는(은) " + type + "입니다.");
    }
}
