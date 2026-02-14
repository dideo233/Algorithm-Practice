package baekjoon.lv7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 맥락]
 * - N과 M의 크기를 가진 두 행렬 A, B를 더하여 각 원소가 공백으로 구분된 합행렬을 출력하는 프로그램을 작성한다.
 * - 입력은 행렬의 규격(N, M)을 시작으로 N개 줄에 걸친 행렬 A의 원소 M개와 동일한 형식의 행렬 B 원소 데이터가 차례로 주어진다.
 * - 행렬의 크기는 최대 100*100이며, 각 원소는 절댓값이 100 이하인 정수로 구성된다.
 *
 * [핵심 포인트]
 * - 행과 열로 구성된 2차원 배열의 구조를 이해하고, 중첩 반복문을 사용하여 각 행과 열의 인덱스에 정확히 접근한다.
 * - 한 줄에 공백으로 구분되어 들어오는 여러 개의 원소들을 StringTokenizer를 활용해 적절히 분리하고 정수형으로 변환하여 배열에 저장한다.
 * - 동일한 위치(인덱스)를 가진 두 행렬의 원소를 서로 더한 뒤, 출력 형식에 맞춰 각 원소 사이에는 공백을, 행의 끝에는 줄바꿈을 처리한다.
 */
public class Program2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] processtion = new int[N][M];

        // 행렬 A 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                processtion[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 행렬 B 입력 및 더하기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                processtion[i][j] += Integer.parseInt(st.nextToken());
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(processtion[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
