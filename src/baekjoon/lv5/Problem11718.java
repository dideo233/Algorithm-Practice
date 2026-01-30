package baekjoon.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 여러 줄의 문자열을 입력받아 입력 받은 그대로 출력하는 문제
 * - 입력 줄 수가 주어지지 않으며, EOF(입력의 끝)까지 반복해서 읽어야 한다
 *
 * [핵심 포인트]
 * - readLine()이 null을 반환하면 입력 종료 (EOF)
 * - 입력 내용을 가공하지 않고 그대로 출력
 * - 빠른 입출력을 위해 BufferedReader 사용
 *   → Scanner는 내부적으로 정규식 기반 토큰 파싱과 추가적인 입력 처리 과정을 거쳐 상대적으로 느리고, 대량 입력 시 시간 초과 가능성 높음
 */
public class Problem11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append('\n');
        }
        System.out.print(sb);

    }
}
