package baekjoon.lv6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 알파벳 대소문자로 이루어진 단어가 주어질 때, 가장 많이 사용된 알파벳을 찾는다.
 * - 단, 대소문자를 구분하지 않는다.
 * - 가장 많이 사용된 알파벳이 여러 개라면 '?'를 출력한다.
 * 
 * [핵심 포인트]
 * - 대소문자 구분 제거를 위해 문자열을 한쪽 케이스(대문자)로 통일하고, 빈도수 계산과 최댓값 판별 로직을 작성한다
 */
public class Problem1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();

        // 빈도수 계산
        int[] counts = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'A'; // ASCII 차를 이용한 인덱스화 (A:0, B:1 ... Z:25)
            counts[index]++; // 해당 알파벳 등장 횟수 증가
        }

        // 최댓값과 결과 문자 판별
        int max = 0;
        char result = '?';

        for (int i = 0; i < 26; i++) {
            if (counts[i] > max) { // 더 큰 빈도 발견 → 최댓값 갱신 및 결과 문자 갱신 (인덱스화된 알파벳을 다시 문자화)
                max = counts[i];
                result = (char) (i + 'A');
            } else if (counts[i] == max) { // 동일한 최댓값이 또 등장 → 최다 알파벳이 여러 개
                result = '?';
            }
        }

        System.out.println(result);
    }
}
