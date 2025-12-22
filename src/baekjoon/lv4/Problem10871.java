package baekjoon.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int x = Integer.parseInt(st1.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st2.nextToken());
            if(temp < x){
                sb.append(temp).append(" ");
            }
        }

        System.out.println(sb);
    }
}
