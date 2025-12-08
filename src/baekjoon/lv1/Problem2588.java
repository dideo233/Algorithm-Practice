package baekjoon.lv1;

import java.util.Scanner;

public class Problem2588 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int one = n*(m%10);
        int ten = n*((m%100)/10);
        int hundred = n*(m/100);

        int result = one + (ten*10) + (hundred*100);

        System.out.println(one);
        System.out.println(ten);
        System.out.println(hundred);
        System.out.println(result);
        sc.close();
    }
}
