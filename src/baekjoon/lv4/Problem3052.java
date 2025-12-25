package baekjoon.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 맥락]
 * - 정수 10개를 입력받아 각각을 42로 나눈 나머지를 구한다
 * - 서로 다른 나머지의 개수를 출력하는 문제
 *
 * [핵심 포인트]
 * - 나머지 값의 범위는 0 ~ 41
 * - 입력 개수(10)가 아니라 값의 범위(42)를 기준으로 중복을 관리해야 함
 *
 * [해결 전략1 - 값 기반 중복 제거]
 * - boolean 배열을 사용해 각 나머지의 등장 여부를 체크
 * - true의 개수를 세어 서로 다른 나머지 개수를 계산
 * - 나머지 값이 인덱스가 된다. 해당 인덱스에 체크해주면 됨. 중복의 경우 이미 체크된 거니 OK
 */
public class Problem3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[] flags = new boolean[42];

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            flags[n % 42] = true;
        }

        int count = 0;
        for (Boolean flag : flags) {
            if(flag) count++;
        }

        System.out.println(count);
    }
}