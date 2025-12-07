package baekjoon.lv1;

import java.util.Scanner;

/**
 * 백준 단계별 문제풀이 1008
 * 문제: 1/3 = 0.3333.... 출력 (절대오차 또는 상대오차가 10-9 이하이면 정답)
 * 풀이: Scanner 사용, / 연산자 사용. (실수 자료형 처리)
 */
public class Problem1008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();

        double result = num1 / num2;
        System.out.println(result);

    }
}
