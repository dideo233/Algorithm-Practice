package baekjoon.lv6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 그룹 단어란, 단어 안의 각 문자가 연속해서만 나타나는 단어를 의미한다. (e.g., ccazzzzbb)
 * - 여러 개의 단어를 입력받아, 그 중 그룹 단어의 개수를 구한다.
 * - 단어는 알파벳 소문자로만 이루어져 있고, 길이는 최대 100이며, 단어 수 N은 100 이하이다.
 */
public class Problem1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < num; i++) {
            String word = br.readLine();
            boolean[] check = new boolean[26]; // 첫 단어 등장 체크용
            char prev = '*';
            boolean isGroupWord  = true;

            for (int j = 0; j < word.length(); j++) {
                char now = word.charAt(j);

                if (prev != now) { // 이전 단어와 현재 단어가 다를 때만 체크 (동일한 경우 그룹 단어 유효하니 체크 X)
                    if (check[now - 'a']) { // now와 다른 prev 이전에도 now와 같은 게 있으니까 그룹 단어 아님
                        isGroupWord = false;
                        break;
                    } else { // 그룹 단어 아니라면 통과하고 다음 문자로 체크
                        prev = now;
                        check[now - 'a'] = true;
                    }
                }
            }

            if  (isGroupWord) {
                count++;
            }
        }

        System.out.println(count);
    }
}



