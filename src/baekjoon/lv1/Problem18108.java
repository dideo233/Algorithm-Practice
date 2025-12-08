package baekjoon.lv1;

import java.util.Scanner;

public class Problem18108 {
    public static void main(String[] args) {
        Scanner SC=new Scanner(System.in);
        int bgYear=SC.nextInt();

        final int DIFF = 543;
        int adYear = bgYear-DIFF;
        System.out.println(adYear);
    }
}
