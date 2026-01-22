package baekjoon.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 알파벳 소문자로 이루어진 단어가 주어질 때, 알파벳 a~z 각각이 단어에서 처음 등장하는 위치를 출력한다.
 * - 단어에 포함되지 않은 알파벳은 -1을 출력한다.
 *
 * [핵심 포인트]
 * - 알파벳 a~z를 인덱스 0~25에 대응시키는 정수 배열을 사용한다.
 * - 단어를 앞에서부터 순회하며, 각 알파벳의 첫 등장 위치만 기록한다.
 * - 이미 기록된 알파벳은 다시 갱신하지 않는다.
 */
public class Problem10809 {

    public static void main(String[] args) throws IOException {
        solveWithIndexArray();     // 정답 풀이 (채점용)
        solveWithBruteForce();  // 다른 풀이 (비교 학습용)
    }

    static void solveWithIndexArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] alphabet = new int[26];

        // 모든 알파벳을 '미등장(-1)' 상태로 초기화
        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a'; // 알파벳 문자를 0~25 인덱스로 변환 ('a'-'a'=0, 'b'-'a'=1)

            // 해당 알파벳이 처음 등장한 경우에만 위치 기록
            if (alphabet[index] == -1) {
                alphabet[index] = i;
            }
        }

        for (int index : alphabet) {
            System.out.print(index + " ");
        }
    }

    /**
     * 알파벳 a~z 각각에 대해 문자열 전체를 직접 탐색하여, 첫 등장 위치를 찾는 브루트포스(완전 탐색) 풀이 방식.
     * 구현은 직관적이지만, 문자열을 알파벳마다 반복 탐색하므로 O(26 × N)의 시간복잡도를 가진다.
     */
    static void solveWithBruteForce() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        for (int i = 0; i < 26; i++) {
            char target = (char) ('a' + i);
            int position = -1;

            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == target) {
                    position = j;
                    break;
                }
            }

            System.out.print(position + " ");
        }
    }
}
