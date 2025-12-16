package baekjoon.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빠른 A+B 문제
 * - 입력의 경우 저수준 입출력 스트림 함수로 속도 향상 가능 (+ split으로 토큰 자르는 것보다 'StringBuilder'가 더 빠름)
 * - 출력의 경우 println는 호출 시마다 출력 버퍼 flush > 느림 (속도는 입력 수에 비례함) > 따라서 출력은 한 번에!
 */
public class Problem15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a + b).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
