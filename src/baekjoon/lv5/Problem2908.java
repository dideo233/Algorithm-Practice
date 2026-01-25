package baekjoon.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 세 자리 수 두 개 A, B가 주어질 때, 크기가 큰 수를 출력한다
 * - 이때 제공된 수의 역수(e.g., 734 > 437)를 구하여 크기 비교를 한다
 *
 * [핵심 포인트]
 * - 입력은 문자열로 받아야 각 자리 숫자를 쉽게 뒤집을 수 있음
 *   (정수로 받으면 자리 분해 로직이 추가되어 오히려 복잡해짐)
 * - 문자열 뒤집기 방법
 *   1. StringBuilder의 reverse() 사용
 *      → 가장 간결하고 안전한 방식
 *      → 내부적으로 가변 배열을 사용하므로 성능 문제 없음 (정석)
 *   2) 반복문으로 직접 뒤집기 (charAt)
 *      → 문자열을 뒤에서부터 순회하며 재조합하는 방식
 *      → 로직 이해에는 좋으나, String += char 형태는 문자열 불변(immutable) 특성상 매번 새 객체를 생성해 비효율적
 */
public class Problem2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(new StringBuilder(s[0]).reverse().toString());
        int b = Integer.parseInt(new StringBuilder(s[1]).reverse().toString());
        System.out.println(Math.max(a, b));
    }
}
