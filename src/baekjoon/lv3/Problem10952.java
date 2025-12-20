package baekjoon.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이 문제는 입력 개수가 주어지지 않음 → for문 사용 불가 (정확하게는 무한 루프)
 * "0 0"은 계산 대상이 아니라 입력 종료를 알리는 신호(sentinel)
 */
public class Problem10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                break;
            }

            sb.append(a + b).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
