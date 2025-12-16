package baekjoon.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalPrice  = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum  = 0;

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            sum += a * b;
        }

        String result = (totalPrice  == sum) ? "Yes" : "No";
        System.out.println(result);

        br.close();
    }
}
