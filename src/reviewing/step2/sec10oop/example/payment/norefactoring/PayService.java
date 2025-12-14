package reviewing.step2.sec10oop.example.payment.norefactoring;

public class PayService {

    public void processPay(String option, int amount) {
        boolean result;

        System.out.println("결제를 시작합니다. Option=" + option + ", Amount=" + amount);
        if (option.equals("kakao")) {
            KakaoPay kakaoPay = new KakaoPay();
            result = kakaoPay.pay(amount);
        } else if (option.equals("naver")) {
            NaverPay naverPay = new NaverPay();
            result = naverPay.pay(amount);
        } else {
            System.out.println("결제 수단이 없습니다");
            result = false;
        }

        if (result) {
            System.out.println("결제 성공");
        } else {
            System.out.println("결제 실패");
        }
    }
}
