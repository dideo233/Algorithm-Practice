package baekjoon.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [주의]
 * - 최소값/최대값을 0으로 초기화하면 안 됨 (입력이 전부 음수일 수 있음)
 * - 첫 번째 입력값으로 min, max를 초기화하거나 Integer.MIN_VALUE / Integer.MAX_VALUE 사용
 * - StringTokenizer는 토큰을 하나씩 꺼내는 용도이며
 *   문자열/정수 배열을 자동으로 만들어주지 않음 (직접 배열 만들어서 초기화 필요)
 */
public class Problem10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp < minNum) minNum = temp;
            if (temp > maxNum) maxNum = temp;
        }

        System.out.println(minNum + " " + maxNum);
    }
}
