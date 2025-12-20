package baekjoon.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 해석]
 * - 입력 개수와 종료 조건이 주어지지 않음
 * - 입력이 끝날 때까지(EOF) 모든 줄을 처리해야 함
 *
 * [입력 종료(EOF)]
 * - readLine()은 더 이상 읽을 입력이 없으면 null을 반환
 * - null은 입력 데이터가 아니라 입력 종료를 알리는 상태 신호
 *
 * [주의 사항]
 * - for문 사용 불가 → while + EOF 조건 사용
 * - readLine()은 한 번만 호출하고, 반환된 문자열을 그대로 사용
 * - 빈 줄("")과 EOF(null)는 서로 다른 개념
 */
public class Problem10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a + b).append("\n");
        }

        System.out.println(sb);
    }
}
