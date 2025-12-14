package reviewing.step2.sec10oop.example.payment.refactoring.services;

import reviewing.step2.sec10oop.example.payment.refactoring.pays.Pay;

public class PayService {

    public void processPay(String option, int amount) {
        System.out.println("결제를 시작합니다. Option=" + option + ", Amount=" + amount);

        Pay pay = PayStore.findPay(option);
        boolean result = pay.pay(amount);

        if (result) {
            System.out.println("결제 성공");
        } else {
            System.out.println("결제 실패");
        }
    }

}
