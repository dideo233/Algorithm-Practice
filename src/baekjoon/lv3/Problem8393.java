package baekjoon.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int total = 0;
        for(int i = 1; i <= n; i++){
            total += i;
        }

        System.out.println(total);
        br.close();
    }
}
