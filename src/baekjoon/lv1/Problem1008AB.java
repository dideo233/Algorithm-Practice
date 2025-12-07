package baekjoon.lv1;

import java.util.Scanner;

/**
 * 백준 단계별 문제풀이 1001 A+B
 * 문제: 1/3 = 0.3333.... 출력
 * 풀이: Scanner 사용 (실수 자료형 처리)
 */
public class Problem1008AB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();

        double result = num1 / num2;
        System.out.println(result);

    }
}
