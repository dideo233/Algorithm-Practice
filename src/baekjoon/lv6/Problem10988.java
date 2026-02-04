package baekjoon.lv6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 알파벳 소문자로만 입력된 단어가 입력되었을 때, 팰린드롬(회문)인지 확인한다
 * - 첫째 줄에 팰린드롬이면 1, 아니면 0을 출력한다.
 */
public class Problem10988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        solveWithReverse(word);       // 방법 1: 문자열 뒤집기
        solveWithTwoPointers(word);   // 방법 2: 투 포인터
    }

    // StringBuilder로 뒤집어서 비교
    public static void solveWithReverse(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println(word.equals(reversed) ? 1 : 0);
    }

    // 투 포인터로 양쪽 문자 비교
    public static void solveWithTwoPointers(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                System.out.println(0);
                return;
            }
            left++;
            right--;
        }
        System.out.println(1);
    }

}
