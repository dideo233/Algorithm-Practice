package reviewing.step1;

/**
 * Java의 변수(Variable)와 자료형(Data Type) 기본 정리
 * - 변수 선언, 초기화, 값 변경
 * - 정수, 실수, 논리, 문자열 등 주요 자료형
 */
public class Variable {
    public static void main(String[] args) {

        /**
         * 1. 변수 선언 및 사용법
         */
        System.out.println("--- 1. 변수 사용법 ---");
        int score; // 변수 선언
        score = 85; // 값 할당 (초기화)
        System.out.println("점수: " + score); // 85

        score = 92; // 새로운 값 할당 (값 변경)
        System.out.println("변경된 점수: " + score); // 92

        int a = 5, b = 3; // 한 줄에 여러 변수 선언 및 초기화
        System.out.println("a: " + a + ", b: " + b); // 5, 3

        // 지역 변수는 사용하기 전에 반드시 초기화해야 함
        // 메모리에 쓰레기 값이 있을 수 있어서, 자바가 안전을 위해 초기화를 강제함

        /**
         * 2. 주요 자료형
         */
        System.out.println("\n--- 2. 주요 자료형 ---");

        // 2-1. 정수 타입
        // int: 기본 정수형 (약 ±21억). 가장 널리 사용됨.
        int normalInt = 1000000000;
        // long: int의 범위를 넘어서는 큰 정수를 다룰 때.
        long bigLong = 8000000000L;

        System.out.println("int 타입: " + normalInt);
        System.out.println("long 타입: " + bigLong);

        // 2-2. 실수 타입
        // double: 기본 실수형. float보다 훨씬 정밀해서 주로 사용됨.
        double preciseDouble = 3.1415926535;
        // float: 특별한 경우가 아니면 잘 안 씀.
        float simpleFloat = 1.25F;

        System.out.println("double 타입: " + preciseDouble);
        System.out.println("float 타입: " + simpleFloat);

        // 2-3. 기타 주요 타입
        // boolean: 논리값. true 또는 false만 저장.
        boolean isLoggedIn = true;
        // char: 문자 하나. 작은따옴표('')로 감쌈.
        char grade = 'A';
        // String: 문자열. 큰따옴표("")로 감쌈. (엄밀히는 참조형이지만 사용법은 기본형처럼 편리함)
        String message = "Hello, Java!";

        System.out.println("boolean 타입: " + isLoggedIn);
        System.out.println("char 타입: " + grade);
        System.out.println("String 타입: " + message);


        /**
         * 3. 실무에사 자주 쓰이는 타입 선택 요약
         * - 정수: int (21억 넘을 것 같으면 long)
         * - 실수: double
         * - 참/거짓: boolean
         * - 문자열: String
         *
         * 이유:
         * - byte, short보다 int 연산이 JVM에 최적화되어 있어 더 빠를 수 있음.
         * - float보다 double이 훨씬 정밀하여 계산 오류를 줄여줌.
         */
    }
}
