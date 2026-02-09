package baekjoon.lv6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳을 알아낸다
 * - 단, 대소문자를 구분하지 않는다.
 * 
 * [핵심 포인트]
 * - 대문자 혹은 소문자로 단어를 통일하고, 빈도수 계산과 최댓값 판별 로직을 작성한다
 */
public class Problem1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();

        // 빈도수 계산
        int[] counts = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'A'; // ASCII 차를 이용한 인덱스화 (A:0, B:1 ... Z:25)            counts[index]++;
            counts[index]++;
        }

        // 최댓값 판별
        int max = 0;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (counts[i] > max) {
                max = counts[i];
                result = (char) (i + 'A'); // 인덱스화된 알파벳을 다시 문자화
            } else if (counts[i] == max) { // 최댓값이 동등한 문자 발생
                result = '?';
            }
        }

        System.out.println(result);
    }
}
