package baekjoon.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1000V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 문자 스트림 변환

        String line = br.readLine();
        String[] tokens = line.split(" ");

        int num1 = Integer.parseInt(tokens[0]); // 문자열 → int 변환
        int num2 = Integer.parseInt(tokens[1]);

        int sum = num1 + num2;
        System.out.println(sum);
        br.close();

        // InputStreamReader 사용; Scanner보다 저수준으로 처리
        // Scanner의 경우 토큰 처리, 자료형 변환 제공 등 유연성 있음
    }
}
