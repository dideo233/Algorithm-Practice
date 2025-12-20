package baekjoon.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 주의: 반복문은 i=1부터 N까지 (i=0이면 불필요한 한 줄 출력됨)
// 주의: 공백/별 개수는 하드코딩하지 말고 반드시 입력값(N)을 기준으로 계산 (입력값 달라지면 틀림)
public class Problem2439 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            //공백
            for (int j = 0; j < count-i; j++) {
                sb.append(" ");
            }

            //별
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
