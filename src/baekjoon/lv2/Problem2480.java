package baekjoon.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputValues = br.readLine().split(" ");

        int firstDice = Integer.parseInt(inputValues[0]);
        int secondDice = Integer.parseInt(inputValues[1]);
        int thirdDice = Integer.parseInt(inputValues[2]);

        int result;

        if (firstDice == secondDice && firstDice == thirdDice) {
            result = 10000 + (firstDice * 1000);
        } else if (firstDice == secondDice || firstDice == thirdDice) {
            result = 1000 + (firstDice * 100);
        } else if (secondDice == thirdDice) {
            result = 1000 + (secondDice * 100);
        } else {
            result = Math.max(Math.max(firstDice, secondDice), thirdDice) * 100;
        }

        System.out.println(result);
        br.close();
    }
}
