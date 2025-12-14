package reviewing.step2.sec10oop.example.payment.refactoring.pays;

public class DefaultPay implements Pay {

    @Override
    public boolean pay(int amount) {
        System.out.println("결제 수단이 없습니다");
        return false;
    }
}
