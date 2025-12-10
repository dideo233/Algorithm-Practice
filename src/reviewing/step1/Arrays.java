package reviewing.step1;

import java.util.Scanner;

public class Arrays {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // [자료형] 기본형 vs 참조형
        // - 기본형(primitive type): 변수에 실제 값을 직접 저장 (e.g., int, double)
        // - 참조형(reference type): 변수에 실제 값이 있는 곳의 주소(참조)를 저장 (e.g., 배열, 객체)
        // -> 배열은 크기가 동적으로 할당되므로 참조형으로 관리됨.

        // 1. 1차원 배열
        int[] students; // 배열 변수 선언
        students = new int[5]; // 배열 생성 (int 5개 공간 할당, 0으로 자동 초기화)

        // 배열 값 대입 (인덱스는 0부터 시작)
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        // 배열 값 사용
        System.out.println(students[0]);
        System.out.println(students[1]);
        System.out.println(students[2]);
        System.out.println(students[3]);
        System.out.println(students[4]);

        // for문을 이용한 순회
        for (int i = 0; i < students.length; i++) {
            System.out.println("학생: " + (i + 1) + ", 점수: " + students[i]);
        }

        // 향상된 for문(for-each)을 이용한 순회
        for(int score : students){
            System.out.println(score);
        }

        // 배열 생성과 초기화를 동시에 하는 방법
        // int[] students2 = new int[]{10, 20, 30, 40, 50}; // 정식 표현
        // int[] students2 = {10, 20, 30, 40, 50}; // 선언과 동시에 할 때만 new int[] 생략 가능

        // 아래 코드는 컴파일 에러 발생
        // int[] students3;
        // students3 = {1, 2, 3, 4, 5}; // 선언과 초기화를 분리할 경우 new int[] 생략 불가

        // 2. 2차원 배열 (2x3)
        int[][] arr = new int[2][3]; //행2, 열3
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;

        // 2차원 배열 직접 출력
        // 0행 출력
        System.out.print(arr[0][0] + " ");
        System.out.print(arr[0][1] + " ");
        System.out.print(arr[0][2] + " ");
        System.out.println();

        // 1행 출력
        System.out.print(arr[1][0] + " ");
        System.out.print(arr[1][1] + " ");
        System.out.print(arr[1][2] + " ");
        System.out.println();

        // 2차원 배열 초기화 단축 표현
        int[][] arr2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // 중첩 for문으로 2차원 배열 순회
        for(int row = 0; row < arr2.length; row++){ //행 길이
            for(int col = 0; col < arr2[row].length; col++){ //각 행의 열 개수
                System.out.print(arr2[row][col] + " ");
            }
            System.out.println();
        }

        // 2차원 배열 값 동적 할당
        int[][] arr3 = new int[5][8];
        int num = 1;
        for (int row = 0; row < arr3.length; row++) {
            for (int col = 0; col < arr3[row].length; col++) {
                arr3[row][col] = num++;
            }
        }

        // 중첩 향상된 for문으로 2차원 배열 순회
        for (int[] row : arr3) { //행 길이
            for (int element : row) { //각 행의 열 개수
                System.out.print(element + " ");
            }
            System.out.println();
        }

        //배열 예제
        Arrays a = new Arrays();
        a.outputSequentialAndReverse();
        a.calculateSumAndAverage();
        a.findMinMaxNumbers();
        a.manageStudentScores();
        a.simpleProductAdmin();
        sc.close();
    }


    /**
     * 응용 1: 입력받은 N개 정수 출력(순차/역순)
     */
    public void outputSequentialAndReverse(){
        int[] numbers = new int[5];

        System.out.print("5개 정수를 입력하세요:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println("순차 출력:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\n역순 출력:");
        for (int i = 4; i >= 0; i--) {
            System.out.print(numbers[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * 응용 2: 입력받은 N개 정수의 합계와 평균 구하기
     */
    public void calculateSumAndAverage() {
        System.out.print("몇 개의 정수를 입력하시겠습니까? ");
        int size = sc.nextInt();

        int[] numbers = new int[size];
        int sum = 0;

        System.out.println(size + "개의 정수를 입력하세요:");
        for(int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
            sum += numbers[i];
        }

        double average = (double) sum / size;
        System.out.println("입력한 정수의 합계: " + sum);
        System.out.println("입력한 정수의 평균: " + average);
    }

    /**
     * 응용 3: 입력받은 N개 정수 중 가장 작은 수와 가장 큰 수 찾기
     */
    public void findMinMaxNumbers() {

        System.out.print("몇 개의 정수를 입력하시겠습니까? ");
        int size = sc.nextInt();

        int[] numbers = new int[size];

        System.out.println(size + "개의 정수를 입력하세요:");
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        int minNumber = numbers[0];
        int maxNumber = numbers[0];

        for (int i = 1; i < size; i++) {
            if (numbers[i] < minNumber) minNumber = numbers[i];
            if (numbers[i] > maxNumber) maxNumber = numbers[i];
        }

        System.out.println("가장 작은 수: " + minNumber);
        System.out.println("가장 큰 수: " + maxNumber);
    }

    /**
     * 응용 4: 여러 학생의 3과목 성적을 입력받아 총점, 평균 계산
     */
    public void manageStudentScores() {
        System.out.print("학생 수를 입력하세요: ");
        int studentCount = sc.nextInt();

        int[][] scores = new int[studentCount][3];
        String[] subjects = {"국어", "영어", "수학"};

        for (int i = 0; i < studentCount; i++) {
            System.out.println((i + 1) + "번 학생의 성적을 입력하세요:");
            for (int j = 0; j < subjects.length; j++) {
                System.out.print(subjects[j] + " 점수: ");
                scores[i][j] = sc.nextInt();
            }
        }

        System.out.println("[성적 결과]");
        for (int i = 0; i < studentCount; i++) {
            int total = 0;
            for (int score : scores[i]) {
                total += score;
            }
            double average = (double) total / subjects.length;
            System.out.printf("%d번 학생 - 총점: %d, 평균: %.1f\n", (i + 1), total, average);
        }
    }

    /**
     * 응용 5: 간단한 상품 등록 및 조회 프로그램
     */
    public void simpleProductAdmin() {
        int maxProducts = 3;
        String[] productNames = new String[maxProducts];
        int[] productPrices = new int[maxProducts];
        int productCount = 0;

        while (true) {
            System.out.println("메뉴를 선택하세요 (1: 상품 등록, 2: 상품 목록, 3: 종료)");
            System.out.print(":");
            int menu = sc.nextInt();
            sc.nextLine(); //개행 제거

            if (menu == 1) {
                if (productCount >= maxProducts) {
                    System.out.println("더 이상 상품을 등록할 수 없습니다.");
                    continue;
                }
                System.out.print("상품 이름을 입력하세요: ");
                productNames[productCount] = sc.nextLine();
                System.out.print("상품 가격을 입력하세요: ");
                productPrices[productCount] = sc.nextInt();
                productCount++;
                System.out.println("상품이 등록되었습니다.");
            } else if (menu == 2) {
                if (productCount == 0) {
                    System.out.println("등록된 상품이 없습니다.");
                } else {
                    System.out.println("[상품 목록]");
                    for (int i = 0; i < productCount; i++) {
                        System.out.println(productNames[i] + ": " + productPrices[i] + "원");
                    }
                }
            } else if (menu == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 메뉴입니다. 다시 선택해주세요.");
            }
        }
    }
}

