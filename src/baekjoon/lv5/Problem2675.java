package baekjoon.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 맥락]
 * - 문자열 S의 각 문자를 R번 반복하여 새로운 문자열 P를 만든다
 * - 이 과정을 테스트 케이스 수만큼 반복해 출력한다
 *
 * [핵심 포인트]
 * - 문자열을 문자 단위로 순회하며 처리하는 기본 패턴
 * - 반복 출력 시 StringBuilder를 사용해 성능 저하를 방지
 */
public class Problem2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for (int j = 0; j < s.length(); j++) {
                sb.append(String.valueOf(s.charAt(j)).repeat(r));

                /*
                 * [동일 동작 - 전통적인 반복 방식. java11 이전]
                 * for (int k = 0; k < r; k++) {
                 *     sb.append(s.charAt(j));
                 * }
                 *
                 * [주의: 비권장 방식]
                 * result += s.charAt(j) + "";
                 * → String은 immutable이므로 반복 시 성능 저하 발생
                 */
                
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
