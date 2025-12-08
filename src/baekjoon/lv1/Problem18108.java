package baekjoon.lv1;

import java.util.Scanner;

public class Problem18108 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int bgYear=sc.nextInt();

        final int DIFF = 543;
        int adYear = bgYear-DIFF;
        System.out.println(adYear);
        sc.close();
    }
}
