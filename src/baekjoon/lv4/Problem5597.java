package baekjoon.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 학생 번호 1~30 중 28명이 과제를 제출
 * - 제출하지 않은 2명의 번호를 오름차순으로 출력
 *
 * [핵심 포인트]
 * - 크기 30의 배열을 제출 여부를 확인하는 flag 용도로 사용 (초기값 변경 없는 0은 미제출을 의미)
 * - 입력된 번호의 위치만 표시하고, 배열을 앞에서부터 순회하며 값이 0인(미제출) 번호를 출력
 */
public class Problem5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] stuNums = new int[30];
        for (int i = 0; i < 28; i++) {
            int temp = Integer.parseInt(br.readLine());
            stuNums[temp-1] = 1;
        }

        for (int i = 1; i <= 30; i++) {
            if (stuNums[i-1] == 0) {
                System.out.println(i);
            }
        }
    }
}
