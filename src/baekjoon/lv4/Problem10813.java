package baekjoon.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 맥락]
 * - 1번부터 N번까지 번호가 붙은 바구니가 있다
 * - 처음에는 각 바구니에 자기 번호(1~N)와 같은 공이 들어 있다
 * - M번 동안 두 바구니를 선택해 공을 서로 교환한다
 *
 * [핵심 포인트]
 * - 배열로 바구니 상태를 관리
 * - 입력은 1-based이므로 배열 접근 시 0-based로 변환
 * - swap(임시 변수)을 이용해 값 교환
 */
public class Problem10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = i+1;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;

            int temp = values[first];
            values[first] = values[second];
            values[second] = temp;
        }

        for(int value : values){
            System.out.print(value + " ");
        }
    }
}
