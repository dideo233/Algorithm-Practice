package baekjoon.lv6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 그룹 단어는 단어 안의 각 문자가 연속해서만 나타나는 단어를 의미한다. (예: ccazzzzbb)
 * - 여러 단어를 입력받아, 그룹 단어의 개수를 구한다.
 * - 각 단어는 알파벳 소문자로만 이루어져 있으며, 길이는 최대 100, 단어 수 N은 100 이하이다.
 *
 * [핵심 포인트]
 * - 단어를 왼쪽에서 오른쪽으로 읽으며, 이전 문자와 다를 때만 확인한다. (prev != now)
 * - 현재 문자가 이전에 등장했지만 연속되지 않고 다시 나타나면 그룹 단어가 아니다. (if(check[now - 'a']) return false)
 * - 연속된 문자는 이미 그룹 단어 조건을 만족하므로 별도의 체크가 필요 없다. (첫 등장 체크)
 * - 주의: 입력을 한 번에 받아 split(" ")으로 단어 배열로 만드면, 첫 줄 숫자 N이 단어 배열에 섞여 오류가 발생할 수 있다.
 */
public class Problem1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // 입력 단어 수
        int count = 0; // 그룹 단어 개수

        for (int i = 0; i < num; i++) {
            String word = br.readLine();
            if (checkGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean checkGroupWord(String word) {
        boolean[] check = new boolean[26]; // 각 알파벳 등장 여부
        char prev = '*'; // 이전 문자 초기값

        for (int j = 0; j < word.length(); j++) {
            char now = word.charAt(j);

            if (prev != now) { // 연속된 문자가 아니라면
                if (check[now - 'a']) { // 이전에 등장한 문자라면 그룹 단어 아님 (해당 조건 통과 시 이전에 등장 X)
                    return false;
                }

                check[now - 'a'] = true; // 첫 등장 체크
                prev = now;
            }
        }

        return true; // 모든 문자가 연속이거나 처음 등장하면 그룹 단어
    }
}



