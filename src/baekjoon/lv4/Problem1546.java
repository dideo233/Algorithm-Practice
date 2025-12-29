package baekjoon.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 맥락]
 * - 시험 점수 N개가 주어질 때, 최고 점수 M을 기준으로 점수를 조작
 * - 각 점수를 (점수 / M) * 100 으로 변환
 * - 변환된 점수들의 평균을 계산하여 출력
 *
 * [핵심 포인트]
 * - 점수 N개를 순회하며 최댓값 M을 구한다
 * - 각 점수를 (점수 / M) * 100 으로 변환
 * - 변환된 점수의 합을 구한 뒤 평균을 계산
 *
 * [주의]
 * - 정수 연산이 아닌 실수 연산을 사용해야 정확한 결과를 얻을 수 있음
 * - 출력은 소수점 오차 허용 범위(절대/상대 오차 1e-2)를 만족하면 정답
 * - float보다 double 사용이 일반적으로 더 안전함
 *
 */
public class Problem1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += (double) scores[i] / max * 100;
        }

        System.out.println(sum / n);
    }
}
