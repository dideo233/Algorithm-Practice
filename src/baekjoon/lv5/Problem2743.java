package baekjoon.lv5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 알파벳으로만 이루어진 단어가 주어질 때
 * - 해당 문자열의 길이를 출력하는 문제
 */
public class Problem2743 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(str.length());
    }
}
