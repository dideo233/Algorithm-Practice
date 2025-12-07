package baekjoon.lv1;

import java.util.Scanner;

/**
 * 백준 단계별 문제풀이 10869
 * 문제: A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성
 * 풀이: 기본 연산자 활용
 */
public class Problem10869 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(num1+num2);
        System.out.println(num1-num2);
        System.out.println(num1*num2);
        System.out.println(num1/num2);
        System.out.println(num1%num2);

    }
}
