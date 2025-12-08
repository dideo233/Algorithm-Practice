package baekjoon.lv1;

import java.util.Scanner;

/**
 * 백준 단계별 문제풀이 18108
 * 문제: 불기 연도 입력 시 서기 연도로 변환
 */
public class Problem18108 {
    public static void main(String[] args) {
        Scanner SC=new Scanner(System.in);
        int bgYear=SC.nextInt();

        int diff = 543;
        int adYear = bgYear-diff;
        System.out.println(adYear);
    }
}
