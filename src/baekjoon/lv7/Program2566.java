package baekjoon.lv7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 맥락]
 * - 9×9 크기의 정수 행렬이 주어졌을 때, 행렬 내에서 가장 큰 값을 찾고 그 값이 위치한 행과 열의 번호를 함께 출력한다.
 * - 입력은 한 줄씩 주어지며, 각 원소의 위치는 1행 1열부터 시작하는 좌표 체계를 따른다.
 *
 * [핵심 포인트]
 * - 모든 값을 저장하는 2차원 배열을 만들 필요 없이, 입력을 받는 동시에 최댓값과 그 위치를 갱신하면 된다.
 * - 최댓값이 갱신되는 순간의 행과 열 인덱스를 함께 저장함으로써 추가적인 탐색 과정을 생략할 수 있다.
 * */
public class Program2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int idx1 = 0, idx2 = 0;

        // 행렬 입력
        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > max) {
                    max = num;
                    idx1 = i;
                    idx2 = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(idx1 + " " + idx2);
    }
}