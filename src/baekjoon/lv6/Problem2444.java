package baekjoon.lv6;

import java.util.Scanner;

/**
 * [문제 맥락]
 * - 첫째 줄에 N(1 ≤ N ≤ 100)이 주어질 때, 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
 * - 출력 형태 (N = 5)
 *
 *       *
 *      ***
 *     *****
 *    *******
 *   *********
 *    *******
 *     *****
 *      ***
 *       *
 *
 * [핵심 포인트]
 * - 대칭 구조의 반복문을 설계한다. 즉, 중앙(N번째 줄)을 기준으로 루프를 두 부분으로 나눈다.
 * - 1부터 N까지, 공백(N-i) → 별(2*i-1) 순서로 출력한다. (상단)
 * - N-1부터 1까지, 공백(N-i) → 별(2*i-1) 순으로 출력한다. (하단)
 */
public class Problem2444 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * (n - i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
