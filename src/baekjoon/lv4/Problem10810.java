package baekjoon.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 맥락]
 * - N개의 값을 배열로 관리
 * - M번의 반복 동안 배열 i번부터 j번 바구니까지 값을 k로 덮어쓴다
 *
 * [핵심 포인트]
 * - 문제 인덱스는 1부터 시작 → 배열은 0부터 시작
 * - 구간 처리 시 시작 인덱스 - 1 보정 필수
 */
public class Problem10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] values = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int j = start - 1; j < end; j++) {
                values[j] = value;
            }
        }

        for(int value : values){
            System.out.print(value + " ");
        }
    }
}
