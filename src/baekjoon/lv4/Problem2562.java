package baekjoon.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 총 9개의 정수를 입력받는다
 * - 그중 최댓값과 최댓값의 위치를 출력하는 문제
 *
 * [주의]
 * - 입력은 1번부터 시작하므로 위치(index)는 1-based. (0-based로 출력하면 오답)
 * - 최댓값이 갱신될 때 값과 위치를 함께 갱신해야 함
 */
public class Problem2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxNum = Integer.MIN_VALUE;
        int index  = 0;

        for(int i = 1; i <= 9; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp > maxNum) {
                maxNum = temp;
                index  = i;
            }
        }
        System.out.println(maxNum);
        System.out.println(index);
    }
}
