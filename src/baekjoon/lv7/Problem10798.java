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
 * - 단어를 행 단위로 읽는 대신 글자 위치(열)를 기준으로 전체 단어를 순회하는 세로 탐색 로직을 작성한다
 * - 단어마다 길이가 상이하므로 참조 인덱스가 실제 문자열 길이를 초과하는지 체크하여 유효한 경우에만 접근한다
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

        // 최대 글자 수(15열)만큼 반복하며 세로로 읽기
        for (int i = 0; i < 15; i++) {
            // 최대 글자 수(15열)만큼 반복하며 세로로 읽기
            for (int j = 0; j < words.length; j++) {
                // i번째 글자가 존재하는 단어만 선택 (범위를 벗어나면 제외)
                if (i < words[j].length()) {
                    sb.append(words[j].charAt(i));
                }
            }
        }

        System.out.println(sb);
    }
}
