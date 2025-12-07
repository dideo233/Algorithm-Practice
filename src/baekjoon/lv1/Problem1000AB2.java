package baekjoon.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 단계별 문제풀이 1000 A+B
 * 문제: 1+2 = 3 출력
 * 풀이: InputStreamReader 사용 (Scanner보다 저수준으로 처리 시)
 */
public class Problem1000AB2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 문자 스트림 변환

        String line = br.readLine();
        String[] tokens = line.split(" ");

        int num1 = Integer.parseInt(tokens[0]); // 문자열 → int 변환
        int num2 = Integer.parseInt(tokens[1]);

        int sum = num1 + num2;
        System.out.println(sum);

    }
}
