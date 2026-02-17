package baekjoon.lv7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 영어 대문자(A~Z), 소문자(a~z), 숫자(0~9)로 이루어진 문자 다섯 개를 입력받는다.
 * - 각 단어는 최대 15자이며, 각 행에 입력되는 문자열의 길이는 서로 다를 수 있다.
 * - 배열을 열 기준으로 좌측부터 우측까지 세로로 읽어 하나의 문자열로 출력한다.
 *
 * [핵심 포인트]
 * - 실제 구현에서는 없는 칸(null/범위 초과)을 건너뛰는 처리가 필요하다
 */
public class Problem10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = new String[5];

        // 단어 입력
        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i < words[j].length()) {
                    sb.append(words[j].charAt(i));
                }
            }
        }

        System.out.println(sb);
    }
}
