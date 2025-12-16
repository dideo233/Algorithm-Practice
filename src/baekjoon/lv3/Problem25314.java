package baekjoon.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = n / 4;

        String str = "int";
        for (int i = 0; i < count; i++) {
             str = "long " + str;

        }

        System.out.println(str);
        br.close();
    }
}
