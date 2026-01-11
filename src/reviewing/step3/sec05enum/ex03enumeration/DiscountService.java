package reviewing.step3.sec05enum.ex03enumeration;

import static reviewing.step3.sec05enum.ex03enumeration.EnumGrade.*;

public class DiscountService {

    public int discount(EnumGrade enumGrade, int price) {
        int discountPercent = 0;

        if (enumGrade == BASIC) {
            discountPercent = 10;
        } else if (enumGrade == GOLD) {
            discountPercent = 20;
        } else if (enumGrade == DIAMOND) {
            discountPercent = 30;
        } else {
            System.out.println("할인 X");
        }

        return price * discountPercent / 100;
    }
}
