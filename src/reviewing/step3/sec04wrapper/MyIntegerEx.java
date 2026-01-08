package reviewing.step3.sec04wrapper;

/**
 * 기본형의 한계와 래퍼 클래스
 *
 * 1. 기본형(Primitive)의 한계
 * - 객체가 아님: 메서드를 가질 수 없음. (데이터와 기능이 분리됨)
 *               객체 참조가 필요한 프레임워크, 제네릭도 사용할 수 없음.
 * - null 불가: '값 없음' 상태를 표현할 수 없음.
 *
 * 2. 대안: 래퍼 클래스 (Wrapper Class)
 *    - 기본형을 객체로 감싸서(Wrap) 유용한 메서드를 제공하고, null을 다룰 수 있게 함.
 */
public class MyIntegerEx {

    public static void main(String[] args) {
        /**
         * 1. 객체가 아님 (메서드 부재)
         * - 기본형(int): 데이터를 처리하려면 외부 메서드(compareTo)에 값을 넘겨야 함.
         * - 래퍼 클래스(MyInteger): 데이터와 기능이 캡슐화되어 있어, 객체 스스로 처리함.
         */
        // [기본형] 외부 메서드 사용
        int value = 10;
        System.out.println("기본형 비교(10 vs 5): " + compareTo(value, 5));
        System.out.println("기본형 비교(10 vs 10): " + compareTo(value, 10));
        System.out.println("기본형 비교(10 vs 20): " + compareTo(value, 20));

        // [래퍼 클래스] 객체 내부 메서드 사용
        MyInteger myInteger = new MyInteger(10);
        System.out.println("객체 비교(10 vs 5): " + myInteger.compareTo(5));
        System.out.println("객체 비교(10 vs 10): " + myInteger.compareTo(10));
        System.out.println("객체 비교(10 vs 20): " + myInteger.compareTo(20));

        /**
         * 2. null을 가질 수 없음 (상태 표현의 한계)
         * - 기본형: 값이 없음을 표현할 때 -1 등을 쓰지만, 실제 값인지 상태 값인지 구분이 모호함.
         * - 래퍼 클래스: 값이 없으면 null을 반환하여 명확하게 표현 가능.
         */
        // [기본형] 모호함의 문제
        // 배열에 -1이 있어서 반환된 건지, 없어서 -1(실패)을 반환한 건지 구분 불가
        int[] intArr = {-1, 0, 1, 2, 3};
        System.out.println("기본형 검색(-1): " + findValue(intArr, -1));
        System.out.println("기본형 검색(100): " + findValue(intArr, 100));

        // [래퍼 클래스] 명확함
        // 값이 없으면 null을 반환하므로 결과가 확실함
        MyInteger[] myIntegers = {new MyInteger(-1), new MyInteger(0), new MyInteger(1)};
        System.out.println("객체 검색(-1): " + MyInteger.findValue(myIntegers, -1)); // -1 (객체 반환)
        System.out.println("객체 검색(100): " + MyInteger.findValue(myIntegers, 100)); // null (없음)


    }

    /**
     * 기본형용 외부 메서드
     */
    public static int compareTo(int intValue, int target) {
        if (intValue < target) {
            return -1;
        }  else if (intValue > target) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int findValue (int[] intArr, int target) {
        for (int value : intArr) {
            if (value == target) {
                return value;
            }
        }
        return -1; // 못 찾았을 때 반환할 값이 마땅치 않음 (보통 -1 혹은 0 사용)
    }
}
