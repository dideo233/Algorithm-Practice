package reviewing.step3.sec04wrapper;


/**
 * int형을 객체로 감싸기 위해 직접 만든 래퍼 클래스
 * (실제 자바의 Integer 클래스와 유사한 구조)
 */
public class MyInteger {
    private final int value; // 불변(Immutable)으로 설계

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // 캡슐화 : 데이터를 가진 객체가 스스로 비교 기능을 수행
    public int compareTo(int target) {
        if (value < target) {
            return -1;
        }  else if (value > target) {
            return 1;
        } else {
            return 0;
        }
    }

    // 유틸리티 : 객체 배열에서 값을 찾는 기능
    public static MyInteger findValue (MyInteger[] intArr, int target) {
        for (MyInteger myInteger : intArr) {
            if (myInteger.getValue() == target) {
                return myInteger;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
