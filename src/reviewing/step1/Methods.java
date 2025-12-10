package reviewing.step1;

import java.util.Scanner;

/**
 * Java의 메서드(Methods) 기본 정리
 * - 메서드의 정의, 호출, 반환
 * - 값 전달 방식 (Pass by Value)
 * - 메서드 오버로딩 (Overloading)
 */
public class Methods {

    /*
    메서드란?
    - 기능 단위의 코드 묶음. (모듈화, 추상화, 재사용성, 유지보수성 향상)
    - 구성: 제어자 반환타입 메서드명(매개변수_목록) { 메서드_본문 }
    - 용어 정리:
      - 매개변수(Parameter): 메서드를 정의할 때 선언하는 변수 (e.g., int a, int b)
      - 인자(Argument): 메서드를 호출할 때 전달하는 실제 값 (e.g., add(5, 3)에서 5와 3)
      - 메서드 시그니처: 메서드 이름 + 매개변수 타입 목록. 오버로딩의 기준이 됨. (반환 타입은 포함 안 됨)
    */

    public static void main(String[] args) {

        /**
         * 1. 메서드 정의와 호출
         */
        System.out.println("--- 1. 메서드 정의와 호출 ---");
        int result = add(5, 3);
        System.out.println("add(5, 3)의 결과: " + result);

        printHeader(); // 반환값이 없는 메서드 호출
        checkAge(25);

        /**
         * 2. 메서드의 값 전달 방식 (Pass by Value)
         * Java는 항상 변수에 담긴 '값'을 복사해서 전달함.
         * 메서드 내에서 매개변수를 변경해도 원본 인자(originalNumber)는 절대 변하지 않음. (단, 참조형 별개)
         */
        System.out.println("\n--- 2. 값 전달 방식 (Pass by Value) ---");
        int originalNumber = 5;
        System.out.println("1. changeNumber 호출 전: " + originalNumber);
        changeNumber(originalNumber); // originalNumber의 '값(5)'만 복사해서 전달
        System.out.println("4. changeNumber 호출 후: " + originalNumber); // 원본은 변하지 않음

        /**
         * 3. 메서드 오버로딩 (Method Overloading)
         * 이름이 같아도 매개변수의 '개수'나 '타입'이 다르면 중복 정의 가능.
         */
        System.out.println("\n--- 3. 메서드 오버로딩 ---");
        System.out.println("add(1, 2) 호출: " + add(1, 2));
        System.out.println("add(1, 2, 3) 호출: " + add(1, 2, 3));
        System.out.println("add(1.5, 2.5) 호출: " + add(1.5, 2.5));

        /**
         * 4. 메서드 예제 (입출금)
         */
        System.out.println("\n--- 4. 메서드 예제 ---");
        int balance = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("| 1.입금 | 2.출금 | 3.잔액확인 | 4.종료");
            System.out.println("-------------------------------------\n");

            int choice = sc.nextInt();
            int amount;
            switch (choice) {
                case 1:
                    System.out.println("입금액을 입력하세요: ");
                    amount = sc.nextInt();
                    balance = deposit(balance, amount);
                case 2:
                    System.out.println("출금액을 입력하세요: ");
                    amount = sc.nextInt();
                    balance = withdraw(balance, amount);
                case 3:
                    System.out.println("현재 잔액: " + balance + "원");
                    break;
                case 4:
                    System.out.println("프로그램 종료");
                    return;
                default:

            }
        }

    }

    /**
     * 두 정수를 더한 결과를 반환하는 메서드
     */
    public static int add(int a, int b) {
        System.out.println("(int, int) 메서드 실행");
        return a + b;
    }

    // [오버로딩 1] 매개변수 '개수'가 다름
    public static int add(int a, int b, int c) {
        System.out.println("(int, int, int) 메서드 실행");
        return a + b + c;
    }

    // [오버로딩 2] 매개변수 '타입'이 다름
    public static double add(double a, double b) {
        System.out.println("(double, double) 메서드 실행");
        return a + b;
    }

    /**
     * 숫자를 받아 2배로 곱한 뒤 출력하는 메서드 (원본 값에 영향을 주지 않음)
     */
    public static void changeNumber(int number) { // main의 originalNumber와는 다른, 별개의 변수
        System.out.println("2. changeNumber 내부 (변경 전): " + number);
        number = number * 2;
        System.out.println("3. changeNumber 내부 (변경 후): " + number);
    }

    /**
     * 나이를 받아 출입 가능 여부를 출력하는 메서드
     * void 메서드에서도 return을 사용하여 로직을 중단시킬 수 있음.
     */
    public static void checkAge(int age) {
        if (age < 18) {
            System.out.println(age + "세: 미성년자는 출입이 금지됩니다.");
            return; // 조건을 만족하면 여기서 메서드 실행을 종료함
        }
        System.out.println(age + "세: 성인입니다. 입장을 환영합니다.");
    }

    /**
     * 프로그램 시작 메시지를 출력하는 메서드 (반환값 없음)
     */
    public static void printHeader() {
        System.out.println("\n== 프로그램을 시작합니다 ==");
        // void 메서드는 마지막 라인에 컴파일러가 자동으로 return; 을 추가해 줌
    }

    /**
     * 입출금 메서드
     */
    private static int deposit(int balance, int amount) {
        balance += amount;
        System.out.println(amount + "원 입금했습니다. 현재 잔액: " + balance + "원");
        return balance;
    }

    private static int withdraw(int balance, int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원 출금했습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println("잔고가 부족합니다.");
        }
        return balance;
    }

}
