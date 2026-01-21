package baekjoon.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - N개의 숫자가 공백 없이 입력될 때, 이 숫자를 모두 합해서 출력한다
 *
 * [핵심 포인트]
 * - 문자를 단순히 정수로 형변환하면 숫자가 아니라 아스키 코드 값이 된다
 * - 숫자 문자를 실제 정수로 변환하기 위해서는 별도의 변환 방식이 필요
 *   - '0' 빼기: 숫자 문자는 '0'의 아스키 코드값을 기준으로 연속되므로, 문자에서 '0'을 빼면 해당 자릿수의 정수를 얻을 수 있다
 *   - Character.getNumericValue() : 문자에 대응하는 숫자 값을 반환하는 메서드를 사용
 */
public class Problem11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // N은 입력 형식상 주어지지만, 실제 로직에는 필요 없음
        String s = br.readLine();

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}

