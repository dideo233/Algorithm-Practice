package baekjoon.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 0~9까지의 숫자 다이얼이 있으며, 알파벳에 따라 해당 번호가 정해진다
 * - 각 번호를 누르는 데 걸리는 시간은 (번호 + 1)초이다
 *   예: 1번 → 2초, 2번 → 3초 …
 * - 입력은 알파벳 문자열로 주어지며, 이를 다이얼 숫자로 변환한다
 *   예: 2(ABC), 3(DEF), 4(GHI), 5(JKL), 6(MNO), 7(PQRS), 8(TUV), 9(WXYZ)
 * - 주어진 문자열을 모두 입력하는 데 걸리는 최소 시간을 구하는 프로그램을 작성한다
 *
 * [핵심 포인트]
 * - 문자열을 한 글자씩 순회하면서 각 문자를 어떤 다이얼 그룹에 속하는지 찾아야 함
 * - 알파벳 → 걸리는 시간으로 바로 변환할 수 있는 "매핑 로직"이 핵심
 */
public class Problem5622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(solveWithTripleLoop(input));      // 3중 반복 방식
        // System.out.println(solveWithRangeComparison(input)); // 범위 비교 방식
    }

    public static int solveWithTripleLoop(String s) {
        String[] dial = {"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"}; // 0~7 인덱스 (+3)
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < dial.length; j++) {
                for (int k = 0; k < dial[j].length(); k++) {
                    if (s.charAt(i) == dial[j].charAt(k)) {
                        result += j + 3;
                    }
                }
            }
        }
        return result;
    }
    public static int solveWithRangeComparison(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c <= 'C') result += 3;
            else if (c <= 'F') result += 4;
            else if (c <= 'I') result += 5;
            else if (c <= 'L') result += 6;
            else if (c <= 'O') result += 7;
            else if (c <= 'S') result += 8;
            else if (c <= 'V') result += 9;
            else result += 10;
        }
        return result;
    }
}
