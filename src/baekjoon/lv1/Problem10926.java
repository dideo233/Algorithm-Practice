package baekjoon.lv1;

import java.util.Scanner;

/**
 * 백준 단계별 문제풀이 10926
 * 문제: 이미 존재하는 아이디(사이트 내 존재한다고 가정)가 주어졌을 때, '??!'를 덧붙여 표현하는 프로그램 작성
 * 풀이: 문자열에 대해 + 연산자 활용
 */
public class Problem10926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str+"??!");

    }
}
