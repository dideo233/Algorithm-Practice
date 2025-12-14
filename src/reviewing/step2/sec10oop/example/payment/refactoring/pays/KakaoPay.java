package reviewing.step2.sec10oop.example.payment.refactoring.pays;

public class KakaoPay implements Pay {

    @Override
    public boolean pay(int amount) {
        System.out.println("카카오페이 시스템과 연결됩니다.");
        System.out.println(amount + "원 결제 시도합니다.");
        return true;
    }
}
