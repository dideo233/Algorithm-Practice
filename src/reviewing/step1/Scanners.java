package reviewing.step1;

import java.util.Scanner;

/**
 * Java의 Scanner 클래스 사용법 정리
 * - 사용자의 키보드 입력을 받는 방법
 * - 주요 메서드(nextLine, nextInt, nextDouble) 사용법
 * - Scanner 사용 방법
 */
public class Scanners {

    // Scanner 객체를 클래스의 정적(static) 멤버로 선언
    // 이렇게 하면 프로그램 내 어디서든 하나의 Scanner 인스턴스를 공유하여 사용할 수 있음
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanners scanners = new Scanners();

        scanners.basicInput();
        scanners.printNumbersBetween();
        scanners.inputMismatchProblem();
        scanners.calculateSumAndAverage();
        scanners.simpleShoppingProgram();

        sc.close();
        System.out.println("프로그램을 종료합니다.");
    }

    /**
     * 예제 1: 기본적인 데이터 타입(String, int, double) 입력받기
     */
    public void basicInput() {
        System.out.println("--- 예제 1: 기본 입력 받기 ---");

        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();

        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();

        System.out.print("키(m)를 입력하세요: ");
        double height = sc.nextDouble();

        System.out.println("입력 정보 확인 -> 이름: " + name + ", 나이: " + age + "세, 키: " + height + "m");
        System.out.println();
    }

    /**
     * 예제 2: 두 수를 입력받아, 두 수 사이의 모든 정수를 출력
     */
    public void printNumbersBetween() {
        System.out.println("--- 예제 2: 두 수 사이의 정수 출력 ---");
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리

        // num1이 num2보다 클 경우, 두 변수의 값을 교환
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        System.out.print(num1 + "부터 " + num2 + "까지의 정수: ");
        for (int i = num1; i <= num2; i++) {
            System.out.print(i);
            if (i != num2) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

    /**
     * 예제 3: nextInt() 후 nextLine() 사용 시 문제점 해결
     */
    public void inputMismatchProblem() {
        System.out.println("--- 예제 3: 이름과 나이 반복 입력받기 (종료는 'exit') ---");
        while (true) {
            System.out.print("이름을 입력하세요 (종료하려면 'exit'): ");
            String name = sc.nextLine();

            if (name.equals("exit")) {
                break;
            }

            System.out.print("나이를 입력하세요: ");
            int age = sc.nextInt(); // 사용자가 '25'를 입력하고 엔터를 치면, '25'만 가져가고 '\n'(엔터)는 버퍼에 남음
            sc.nextLine(); // 위에서 남겨진 '\n'을 읽어서 버리는 역할. 이게 없으면 다음 루프의 name 입력이 스킵됨.

            System.out.println("=> 이름: " + name + ", 나이: " + age);
        }
        System.out.println();
    }

    /**
     * 예제 4: -1을 입력할 때까지 숫자를 받아 합계와 평균 계산
     */
    public void calculateSumAndAverage() {
        System.out.println("--- 예제 4: 합계 및 평균 계산 (-1 입력 시 종료) ---");
        int sum = 0;
        int count = 0;

        while (true) {
            System.out.print("숫자를 입력하세요: ");
            int input = sc.nextInt();

            if (input == -1) {
                break;
            }
            sum += input;
            count++;
        }
        sc.nextLine(); // 개행 문자 처리

        if (count == 0) {
            System.out.println("입력된 숫자가 없습니다.");
        } else {
            double average = (double) sum / count;
            System.out.println("입력한 숫자들의 합계: " + sum);
            System.out.println("입력한 숫자들의 평균: " + average);
        }
        System.out.println();
    }

    /**
     * 예제 5: 상품 입력, 결제, 종료 기능이 있는 간단한 쇼핑몰 프로그램
     */
    public void simpleShoppingProgram() {
        System.out.println("--- 예제 5: 간단한 쇼핑몰 프로그램 ---");
        int totalCost = 0;

        while(true) {
            System.out.println("옵션을 선택하세요 (1: 상품 입력, 2: 결제, 3: 종료)");
            System.out.print(" > ");
            int option = sc.nextInt();
            sc.nextLine(); // 옵션 선택 후 남은 개행 문자 처리

            if (option == 1) {
                System.out.print("상품명을 입력하세요: ");
                String productName = sc.nextLine();

                System.out.print("가격을 입력하세요: ");
                int price = sc.nextInt();

                System.out.print("수량을 입력하세요: ");
                int quantity = sc.nextInt();

                int itemTotal = price * quantity;
                totalCost += itemTotal;
                System.out.println("=> " + productName + " " + quantity + "개 담김 (합계: " + itemTotal + "원)\n");

            } else if (option == 2) {
                System.out.println("=> 총 결제 금액: " + totalCost + "원");
                totalCost = 0; // 결제 후 총액 초기화
                System.out.println();

            } else if (option == 3) {
                break; // 프로그램 종료

            } else {
                System.out.println("=> 잘못된 옵션입니다. 다시 선택해주세요.\n");
            }
        }
    }
}
