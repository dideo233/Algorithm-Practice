package baekjoon.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int hour = Integer.parseInt(input[0]);
        int minute = Integer.parseInt(input[1]);

        minute = minute - 45;

        if(minute > 0) {
            hour = hour - 1;
        } else {
            minute = 60 - (minute * -1);
            hour = hour - 1;
            if (hour < 0) hour = 23;
        }

        System.out.println(hour + " " + minute);
        br.close();
    }
}
