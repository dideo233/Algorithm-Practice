package baekjoon.lv6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 맥락]
 * - 입력된 단어에서 크로아티아 특수 알파벳(c=, c-, dz=, d-, lj, nj, s=, z=)은 한 글자로 간주하고, 
 * - 나머지는 알파벳 한 글자로 계산하여 전체 알파벳 개수를 구한다
 * 
 * [핵심 포인트]
 * - dz=와 같이 세 글자가 모여 하나의 알파벳을 이루는 경우를 포함하여, 표에 명시된 조합은 반드시 하나의 단위로 묶어서 처리해야 한다
 */
public class Problem2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        String[] croatiaAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        // 입력 단어 내 크로아티안 알파벳이 있으면 지움 처리용 "*"로 치환
        for (String s : croatiaAlphabet) {
            if (word.contains(s)) {
                word = word.replace(s, "*");
            }
        }

        System.out.println(word.length());
    }
}
