package baekjoon.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 영어 대소문자와 공백으로 이루어진 문자열이 주어질 때, 단어의 개수를 구한다.
 * - 중복 단위는 개별적으로 센다
 *
 * [핵심 포인트]
 * - 연속 공백, 앞뒤 공백, 공백만 있는 입력 등 예외 케이스를 처리하지 않으면 오답이 발생함.
 * - 주의할 점:
 *   1. 문자열이 공백으로 시작하거나 끝날 수 있음 → 앞뒤 공백 제거 필요 (trim() 또는 strip()).
 *   2. 단어 사이 공백이 1개 이상일 수 있음 → split 시 "\\s+"를 사용하는 것이 안전함. (\s: 공백문자, +: 1개 이상)
 *   3. split(" ")은 빈 문자열을 분리해도 [""]를 반환하므로 단어가 없어도 1로 잘못 계산될 수 있음
 *      → 빈 문자열인지 먼저 확인 (isEmpty()) 필요.
 */
public class Problem1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().strip();

        if(s.isEmpty()) {
            System.out.println(0);
        } else {
            String[] wordCnt = s.split("\\s+");
            System.out.println(wordCnt.length);
            System.out.println("".length());
        }
    }
}
