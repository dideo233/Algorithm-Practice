package baekjoon.lv1;

import java.util.Scanner;

/**
 * 백준 단계별 문제풀이 1000 A+B
 * 문제: 1+2 = 3 출력
 * 풀이: Scanner 사용
 */
public class Problem1000AB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();  // 숫자 토큰 자동 변환
        int num2 = sc.nextInt();

        int sum = num1 + num2;
        System.out.println(sum);

    }
}
