package reviewing.step2.sec05.accessmodifier.example;

public class BankAccount {
    private int balance;

    public BankAccount() {
        balance = 0;
    }

    public void deposit(int amount) {
        if (isAmountValid(amount)) {
            balance += amount;
            System.out.println(amount + "원 입금 완료.");
        } else {
            System.out.println("유효한 금액이 아닙니다");
        } 
    }

    public void withdraw(int amount) {
        if (isAmountValid(amount) && (balance - amount) >= 0) {
            balance -= amount;
            System.out.println(amount + "원 출금 완료.");
        } else {
            System.out.println("유효하지 않거나 잔액이 부족합니다.");
        }
    }

    public int getBalance() {
        return balance;
    }
    
    // 내부 도우미 메서드 -> 외부 공개 X, private으로 숨김
    // public은 외부 공개 -> 개발자의 혼란 유발! (내가 검증하라고 공개한 것인가?)
    private boolean isAmountValid(int amount) {
        return amount > 0;
    }
}
