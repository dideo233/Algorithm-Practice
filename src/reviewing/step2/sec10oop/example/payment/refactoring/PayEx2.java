package reviewing.step2.sec10oop.example.payment.refactoring;

import reviewing.step2.sec10oop.example.payment.refactoring.services.PayService;

import java.util.Scanner;

/**
 * 예제 2-2 사용자 입력
 * - main도 사용자 입력 받으니까 수정 안 해도 됨
 * - 이제 PayStore만 수정하면 됨
 */
public class PayEx2 {
    public  static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PayService payService = new PayService();

        while (true) {
            System.out.print("결제 수단 입력하세요: ");
            String payOption = sc.nextLine();

            if (payOption.equals("exit")) {
                System.out.print("프로그램을 종료합니다");
                return;
            }

            System.out.println("결제 금액 입력하세요: ");
            int amount = sc.nextInt();
            sc.nextLine();

            payService.processPay(payOption, amount);
        }

    }
}
