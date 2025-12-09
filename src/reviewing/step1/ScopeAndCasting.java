package reviewing.step1;

/**
 * Java의 스코프(Scope)와 형변환(Casting) 정리
 * - 스코프: 변수가 살아있는 유효 범위
 * - 형변환: 데이터 타입을 다른 타입으로 변환하는 것
 */
public class ScopeAndCasting {

    public static void main(String[] args) {

        /**
         * 1. 스코프 (Scope)
         * 변수의 접근 가능한 범위. 변수는 자신이 선언된 코드 블록 `{}` 안에서만 생존.
         */
        System.out.println("--- 1. 스코프 (Scope) ---");
        int m = 10; // main 블록에서 선언된 변수 m

        if (true) {
            int x = 20; // if 블록에서 선언된 변수 x
            System.out.println("if 블록 안 -> m = " + m); // 내부에서 외부 변수 접근 가능
            System.out.println("if 블록 안 -> x = " + x);
        } // if 블록이 끝나면서 변수 x는 소멸됨

        System.out.println("main 블록 -> m = " + m);
        // System.out.println("main 블록 -> x = " + x); // 컴파일 에러. x에 접근 불가.

        // [스코프를 지켜야 하는 이유]
        // 1. 메모리 효율: 불필요한 변수가 메모리에 계속 남아있는 것을 방지.
        // 2. 코드 단순성: 변수의 영향 범위를 최소화하여 유지보수를 쉽게 만듦.

        // 좋은 예: 변수를 꼭 필요한 범위 안에서만 사용
        int j = 10;
        if (j > 0) {
            int temp = j * 2; // temp는 이 if 블록 안에서만 필요함
            System.out.println("계산 결과(if 내부): " + temp);
        } // if 블록이 끝나면 temp는 깔끔하게 사라짐


        /**
         * 2. 형변환 (Casting)
         * 데이터의 타입을 다른 타입으로 바꾸는 작업.
         */
        System.out.println("\n--- 2. 자동(묵시적) 형변환 ---");
        // 작은 데이터 타입 -> 큰 데이터 타입으로 변환될 때 자동으로 발생. (데이터 손실 없음)
        // 표현 범위: int < long < double
        int intValue = 10;

        long longValue = intValue; // int(10) -> long(10L) 자동 변환
        System.out.println("int -> long: " + longValue);

        double doubleValue = longValue; // long(10L) -> double(10.0) 자동 변환
        System.out.println("long -> double: " + doubleValue);


        System.out.println("\n--- 3. 명시적 형변환 ---");
        // 큰 데이터 타입 -> 작은 데이터 타입으로 변환될 때 개발자가 직접 지정해야 함. (데이터 손실 가능성)
        double largeNum = 1.5;
        // int smallNum = largeNum; // 컴파일 에러 발생
        int smallNum = (int) largeNum; // (int)를 붙여 강제로 형변환
        System.out.println("double -> int (소수점 버림): " + smallNum); // 1 (0.5 손실)

        // 오버플로우: 변환하려는 값이 대상 타입의 표현 범위를 넘어서는 경우
        long hugeNum = 2147483648L; // int의 최대값(약 21억)보다 1 큼
        int overflowNum = (int) hugeNum;
        System.out.println("long -> int (오버플로우 발생): " + overflowNum); // -2147483648 (의도치 않은 값)


        /**
         * 4. 연산과 형변환
         * - 같은 타입끼리 연산하면 결과도 같은 타입.
         * - 다른 타입끼리 연산하면, 더 큰 타입으로 자동 형변환되어 계산됨.
         */
        System.out.println("\n--- 4. 연산과 형변환 ---");
        int a = 3;
        int b = 2;

        // 1. 정수끼리의 나눗셈
        int result1 = a / b;
        System.out.println("int / int = " + result1); // 1 (결과가 int이므로 소수점 버림)

        // 2. 실수로 결과를 받고 싶지만, 계산은 정수끼리 먼저 일어남
        double result2 = a / b;
        // 3 / 2 -> 1 (int) 계산이 먼저 끝난 후,
        // double 변수에 1이 담기면서 1.0으로 자동 형변환됨.
        System.out.println("double = (int / int) -> " + result2); // 1.0 (의도와 다름)

        // 3. 올바른 실수 결과를 얻는 법
        // 계산 과정에 실수가 포함되도록, 둘 중 하나를 명시적으로 형변환.
        double result3 = (double) a / b;
        // (double) 3 / 2 -> 3.0 / 2 -> 3.0 / 2.0 (자동 형변환) -> 1.5
        System.out.println("(double)int / int = " + result3); // 1.5 (의도대로 계산됨)
    }
}
