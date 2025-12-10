package baekjoon.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int hour = Integer.parseInt(str[0]);
        int minute = Integer.parseInt(str[1]);
        int cookingTime = Integer.parseInt(br.readLine());

        minute += cookingTime;

        if(minute > 59){
            hour += minute / 60;
            minute %= 60;

            if(hour > 23){
                hour -= 24;
            }
        }

        System.out.println(hour + " " + minute);
        br.close();
    }
}
