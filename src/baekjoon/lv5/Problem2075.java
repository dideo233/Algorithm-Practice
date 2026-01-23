package baekjoon.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 맥락]
 * - 문자열 S를 입력받은 후, 각 문자를 R번 반복하여 P를 만든 후 출력한다
 * - 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
 * - S에는 QR Code "alphanumeric" 문자만 들어있다. (0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./:)
 */
public class Problem2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for (int j = 0; j < s.length(); j++) {
                String p = String.valueOf(s.charAt(j)).repeat(r);
                sb.append(p);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
