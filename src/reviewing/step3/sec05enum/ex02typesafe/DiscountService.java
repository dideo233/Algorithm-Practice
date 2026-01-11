package reviewing.step3.sec05enum.ex02typesafe;

public class DiscountService {

    // 파라미터 타입을 ClassGrade로 제한
    public int discount(ClassGrade classGrade, int price) {
        int discountPercent = 0;

        // 참조형이지만 상수 객체(싱글톤 개념)이므로 '==' 비교가 가능하고 더 안전함
        if (classGrade == ClassGrade.BASIC) {
            discountPercent = 10;
        } else if (classGrade == ClassGrade.GOLD) {
            discountPercent = 20;
        } else if (classGrade == ClassGrade.DIAMOND) {
            discountPercent = 30;
        } else {
            System.out.println("할인 X");
        }

        return price * discountPercent / 100;
    }
}
