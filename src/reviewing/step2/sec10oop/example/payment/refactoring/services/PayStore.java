package reviewing.step2.sec10oop.example.payment.refactoring.services;

import reviewing.step2.sec10oop.example.payment.refactoring.pays.*;

public abstract class PayStore {

    public static Pay findPay(String option) {
        if (option.equals("kakao")) {
            return new KakaoPay();
        } else if (option.equals("naver")) {
            return new NaverPay();
        } else if (option.equals("new")) {
            return new NewPay();
        } else {
            return new DefaultPay();
        }
    }

}
