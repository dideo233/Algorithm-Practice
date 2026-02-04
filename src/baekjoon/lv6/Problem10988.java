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
        String reversed  = new StringBuilder(word).reverse().toString();

        if (word.equals(reversed)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
