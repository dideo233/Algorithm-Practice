package baekjoon.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        float[] scores = new float[n];

        float max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Float.parseFloat(st.nextToken());
            if(scores[i] > max) max = scores[i];
        }

        float sum = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = (scores[i] / max) * 100;
            sum += scores[i];
        }

        System.out.println(sum / n);
    }
}
