package reviewing.step2.sec10oop.example.payment.refactoring;

import reviewing.step2.sec10oop.example.payment.refactoring.services.PayService;

/**
 * 예제 2-1 리펙토링
 *
 * [변하는 부분]
 * 1. Main의 메서드 사용 부분
 * 2. 인터페이스 구현
 *
 * [변한 부분]
 * 1. 서비스 로직에 다형성 적용
 * 2. 공통 분모 (PayStore 체크 로직) 분리
 *
 * > 기존 : PayService에서 기능 추가할 때마다 각 Pay 수단별로 객체 생성 후 참조하며 비지니스 로직 건드렸음
 * > 현재 : 구현할 때마다 PayStore에 체크 로직만 추가하고 Main의 기능 사용 부분만 넘기만 됨
 */
public class PayEx {
    public  static void main(String[] args) {

        PayService payService = new PayService();

        String payOption1 = "kakao";
        int amount1 = 5000;
        payService.processPay(payOption1, amount1);

        System.out.println();

        String payOption2 = "naver";
        int amount2 = 10000;
        payService.processPay(payOption2, amount2);

        System.out.println();

        String payOption3 = "bad";
        int amount3 = 15000;
        payService.processPay(payOption3, amount3);

        System.out.println();

        String payOption4 = "new";
        int amount4 = 12000;
        payService.processPay(payOption4, amount4);

    }
}
