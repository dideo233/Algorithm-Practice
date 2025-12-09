package reviewing.step1;

/**
 * Java의 주요 반복문(Loops) 정리
 * - while, do-while: 특정 조건이 만족되는 동안 반복
 * - for: 정해진 횟수만큼 반복
 * - break, continue: 반복 흐름 제어
 */
public class loops {

    public static void main(String[] args) {

        /**
         * 1. while 문
         * 조건식이 참(true)인 동안 코드를 반복 실행. 가장 기본적인 반복문.
         */
        System.out.println("--- 1. while 문 ---");
        int sum1 = 0;
        int i = 1;

        while (i <= 10) {
            sum1 += i;
            i++;
        }
        System.out.println("1부터 10까지의 합 (while): " + sum1);


        /**
         * 2. do-while 문
         * 코드를 최소 한 번은 무조건 실행한 뒤, 조건을 검사하여 반복 여부를 결정.
         */
        System.out.println("\n--- 2. do-while 문 ---");
        int j = 10;

        do {
            System.out.println("현재 j의 값 (최초 1회는 무조건 실행): " + j);
            j++;
        } while (j < 5); // 조건식(j < 5)은 false지만, do 블록은 이미 실행되었음


        /**
         * 3. break 와 continue
         * break: 가장 가까운 반복문을 즉시 탈출.
         * continue: 현재 반복을 중단하고, 다음 반복으로 바로 넘어감.
         */
        System.out.println("\n--- 3. break 와 continue ---");
        // break 예시: 합계가 10을 초과하면 즉시 반복 중단
        int sum2 = 0;
        int k = 1;
        while (true) { // 무한 루프
            sum2 += k;
            if (sum2 > 10) {
                System.out.println("합이 10을 초과하여 종료. k=" + k + ", sum=" + sum2);
                break;
            }
            k++;
        }

        // continue 예시: 3을 건너뛰고 출력
        System.out.println("3을 건너뛰고 출력:");
        int m = 1;
        while (m <= 5) {
            if (m == 3) {
                m++; // continue 전에 증감식을 처리해야 무한 루프에 빠지지 않음
                continue;
            }
            System.out.println("현재 m의 값: " + m);
            m++;
        }


        /**
         * 4. for 문
         * 초기식, 조건식, 증감식을 한 줄에 작성하여 반복 횟수가 명확한 경우에 주로 사용.
         */
        System.out.println("\n--- 4. for 문 ---");
        int sum3 = 0;
        for (int n = 1; n <= 10; n++) {
            sum3 += n;
        }
        System.out.println("1부터 10까지의 합 (for): " + sum3);

        // for 문으로 무한 루프 만들기 (while(true)와 동일)
        int sum4 = 0;
        int p = 1;
        for (; ; ) {
            sum4 += p;
            if (sum4 > 10) {
                System.out.println("합이 10을 초과하여 종료. p=" + p + ", sum=" + sum4);
                break;
            }
            p++;
        }

        // 향상된 for 문 (for-each)
        // 배열이나 컬렉션의 모든 요소를 처음부터 끝까지 순회할 때 사용.
        System.out.println("\n향상된 for 문 (for-each):");
        int[] numbers = {10, 20, 30};
        for (int number : numbers) {
            System.out.println("배열의 요소: " + number);
        }

        /**
         * 5. 중첩 for 문
         * for 문 내부에 또 다른 for 문을 사용하여 다차원적인 작업을 수행.
         */
        System.out.println("\n--- 5. 중첩 for 문 ---");

        // 구구단 출력
        System.out.println("\n구구단 출력:");
        for (int dan = 2; dan <= 9; dan++) {
            System.out.print(dan + "단: ");
            for (int num = 1; num <= 9; num++) {
                System.out.print(dan + "*" + num + "=" + (dan * num) + " ");
            }
            System.out.println(); // 한 단이 끝나면 줄바꿈
        }

        // 별 찍기 (피라미드)
        System.out.println("\n별 찍기 (피라미드):");
        int rows = 5;
        for (int q = 1; q <= rows; q++) {
            // 공백 출력
            for (int r = 1; r <= rows - q; r++) { //층별로 별 밀어주기
                System.out.print(" ");
            }
            // 별 출력
            for (int s = 1; s <= 2 * q - 1; s++) { //1~부터 홀수개만큼 출력해야 하니 q * 2를 해주되 -1 빼는 조건식
                System.out.print("*");
            }
            System.out.println();
        }

        /*
         * - for: 반복 횟수가 명확할 때. (e.g., "10번 반복해", "배열 길이만큼 반복해")
         *   -> 코드가 간결하고 루프 변수 관리가 편함.
         *
         * - while: 반복 횟수가 불명확하고, 특정 조건에 따라 종료될 때. (e.g., "사용자가 'exit'를 입력할 때까지")
         *   -> 더 유연한 조건 설정이 가능.
         */
    }
}
