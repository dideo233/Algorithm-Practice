package reviewing.step3.sec04wrapper;

import java.util.Random;

/**
 * 1. Math 클래스
 *    - 수학 계산(최대/최소, 반올림, 제곱근 등)을 위한 static 메서드 모음.
 *
 * 2. Random 클래스
 *    - 다양한 타입(int, double, boolean)의 난수를 유연하게 생성하는 객체.
 *    - [Seed(시드)]: 난수 생성 알고리즘의 기준값. 현재 시간(nanoTime) 등을 기반으로 자동 설정
 *                   시드가 같으면 항상 똑같은 난수 패턴이 생성됨 (테스트 검증에 활용 가능)
 */
public class MathRandomEx {
    public static void main(String[] args) {
        /**
         * 1. Math 클래스 (기본 연산)
         */
        // 기본 연산
        System.out.println("max(10, 20): " + Math.max(10, 20)); // 최대값
        System.out.println("min(10, 20): " + Math.min(10, 20)); // 최소값
        System.out.println("abs(-10): " + Math.abs(-10));       // 절댓값

        // 반올림 및 정밀도
        System.out.println("ceil(2.1): " + Math.ceil(2.1));   // 올림 (3.0)
        System.out.println("floor(2.1): " + Math.floor(2.1)); // 내림 (2.0)
        System.out.println("round(2.5): " + Math.round(2.5)); // 반올림 (3)

        // 기타
        System.out.println("sqrt(4): " + Math.sqrt(4));     // 제곱근 (2.0)
        System.out.println("random(): " + Math.random());   // 0.0 ~ 1.0 사이 무작위 double

        /**
         * 2. Random 클래스
         */
        Random random = new Random();

        // 다양한 타입의 난수
        System.out.println("int: " + random.nextInt());         // int 전 범위
        System.out.println("double: " + random.nextDouble());   // 0.0 ~ 1.0
        System.out.println("boolean: " + random.nextBoolean()); // true/false

        // 범위 지정 (0 ~ Bound-1)
        int rangeNum1 = random.nextInt(10); // 0 ~ 9
        System.out.println("0~9 난수: " + rangeNum1);

        int rangeNum2 = random.nextInt(10) + 1; // 1 ~ 10
        System.out.println("1~10 난수: " + rangeNum2);

        // Seed 고정
        Random seededRandom = new Random(1); // 시드값을 1로 고정
        System.out.println("고정된 난수1: " + seededRandom.nextInt(100));
        System.out.println("고정된 난수2: " + seededRandom.nextInt(100));
    }
}
