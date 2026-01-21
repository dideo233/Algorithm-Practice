package baekjoon.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 각 문자열에 대해 첫 글자와 마지막 글자를 추출해 출력한다
 */
public class Problem9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String string = str.charAt(0) + "" + str.charAt(str.length() - 1);
            sb.append(string).append("\n");
        }
        System.out.println(sb);
    }
}
