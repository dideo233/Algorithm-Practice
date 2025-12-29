package baekjoon.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 요약]
 * - 1번부터 N번까지 번호가 적힌 바구니가 순서대로 놓여 있음
 * - M번에 걸쳐, 지정된 구간 [i, j]의 바구니 순서를 역순으로 뒤집음
 * - 모든 연산을 순서대로 수행한 뒤 최종 바구니 상태를 출력
 *
 * > 구간 뒤집기(reverse) 문제, 배열의 일부 구간을 대상으로 역순 처리
 *
 * [핵심 포인트]
 * - 바구니를 배열로 관리 (0-based 인덱스)
 * - 각 연산마다 i, j를 0-based로 변환
 * - 구간의 양 끝을 가리키는 좌/우 포인터를 사용해 서로 교환
 * - 포인터를 안쪽으로 좁히며 절반까지만 swap 수행
 *
 * [주의 사항]
 * - 입력은 1-based, 배열은 0-based이므로 인덱스 변환에 주의
 * - 루프 조건과 상태 변경을 섞지 않도록 구현
 */

public class Problem10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] basket = new int[n];
        for (int i = 0; i < n; i++){
            basket[i]=i+1;
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = a-1; j < b; j++){
                int temp = basket[j];
                basket[j] = basket[b-1];
                basket[b-1] = temp;
                b--;
            }
        }

        for (int num :  basket){
            System.out.print(num + " ");
        }
    }
}
