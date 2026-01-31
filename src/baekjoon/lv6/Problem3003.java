package baekjoon.lv6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 맥락]
 * - 0~10 사이의 킹, 퀸, 룩, 비숍, 나이트, 폰의 개수가 주어진다.
 * - 올바른 개수(킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개)와 비교했을 때, 각 체스말을 몇 개 더하거나 빼야 하는지 구하는 문제.
 */
public class Problem3003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] correctPieces = {1, 1, 2, 2, 2, 8};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < correctPieces.length; i++) {
            int inputPiece = Integer.parseInt(st.nextToken()); // 현재 가진 말 개수
            sb.append(correctPieces[i] - inputPiece);
            if (i < correctPieces.length - 1) sb.append(" ");
        }

        System.out.println(sb);
    }
}
