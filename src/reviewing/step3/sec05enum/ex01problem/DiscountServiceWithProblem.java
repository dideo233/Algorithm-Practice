package reviewing.step3.sec05enum.ex01problem;

public class DiscountServiceWithProblem {

    public int discountConstant(String grade, int price) {
        int discountPercent = 0;

        if (grade.equals(StringGrade.BASIC)) {
            discountPercent = 10;
        } else if (grade.equals(StringGrade.GOLD)) {
            discountPercent = 20;
        } else  if (grade.equals(StringGrade.DIAMOND)) {
            discountPercent = 30;
        } else {
            System.out.println(grade + ": 할인 X");
        }

        return price * discountPercent / 100;
    }

    public int discountNoEnum(String grade, int price) {
        int discountPercent = 0;

        if (grade.equals("BASIC")) {
            discountPercent = 10;
        } else if (grade.equals("GOLD")) {
            discountPercent = 20;
        } else  if (grade.equals("DIAMOND")) {
            discountPercent = 30;
        } else {
            System.out.println(grade + ": 할인 X");
        }

        return price * discountPercent / 100;
    }
}
