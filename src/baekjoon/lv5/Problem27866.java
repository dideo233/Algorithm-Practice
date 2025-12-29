package baekjoon.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 문자열 S와 정수 i가 주어질 때
 * - 문자열 S의 i번째 문자를 출력하는 문제
 */
public class Problem27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        System.out.println(str.charAt(n-1));
    }
}