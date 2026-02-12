package baekjoon.lv6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 맥락]
 * - 20개의 전공 과목에 대한 정보(과목명, 학점, 등급)가 공백을 구분자로 하여 입력으로 주어진다.
 * - 전공평점은 각 과목의 '학점 × 과목평점'의 총합을 '학점의 총합'으로 나누어 산출한다.
 * - 'A+'(4.5)부터 'F'(0.0)까지 지정된 등급별 평점 기준표를 따르며, 'P'가 아닌 과목들만 사용하여 전공평점을 계산한다.
 **/
 public class Problem25206 {
    public  static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalSum = 0;
        double scoreSum = 0;

        StringTokenizer st;

        for (int i = 1; i <= 20; i++){
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken(); // 미사용
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(grade.equals("P")) {
                continue;
            }

            double gradePoint = 0.0;
            switch (grade) {
                case "A+": gradePoint = 4.5; break;
                case "A0": gradePoint = 4.0; break;
                case "B+": gradePoint = 3.5; break;
                case "B0": gradePoint = 3.0; break;
                case "C+": gradePoint = 2.5; break;
                case "C0": gradePoint = 2.0; break;
                case "D+": gradePoint = 1.5; break;
                case "D0": gradePoint = 1.0; break;
                case "F":  gradePoint = 0.0; break;
            }

            totalSum += credit;                // 총 학점의 합
            scoreSum += (credit * gradePoint); // 전공 평점 : (학점 × 과목평점)의 합
        }

        System.out.printf("%.4f", scoreSum / totalSum);
    }
}
