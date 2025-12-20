package baekjoon.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * StringBuilder vs StringBuffer
 *
 * - 둘 다 문자열을 효율적으로 변경(추가)할 수 있는 가변 문자열 클래스
 * - String은 불변(immutable)이라 문자열 변경 시마다 새로운 객체가 생성됨
 *
 * - StringBuilder와 StringBuffer의 핵심 차이점은 동기화(synchronized) 여부
 *   - StringBuilder : 동기화 없음 → 단일 스레드에서 빠름 (알고리즘/일반 사용)
 *   - StringBuffer  : 메서드 단위 동기화 → 멀티스레드 안전 (오버헤드 존재)
 */

public class Problem11022 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i).append(": ")
                    .append(a).append(" + ").append(b)
                    .append(" = ").append(a + b).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}

