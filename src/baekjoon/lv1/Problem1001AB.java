package baekjoon.lv1;

import java.util.Scanner;

/**
 * 백준 단계별 문제풀이 1001 A-B
 * 문제: 3-2 = 1 출력
 * 풀이: Scanner 사용
 */
public class Problem1001AB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int result = num1 - num2;
        System.out.println(result);
    }
}
