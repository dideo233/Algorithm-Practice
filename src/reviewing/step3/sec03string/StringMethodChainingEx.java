package reviewing.step3.sec03string;

/**
 * 메서드 체이닝 (Method Chaining)
 * - 메서드 호출을 사슬(Chain)처럼 연결해서 연달아 호출하는 기법.
 * - 핵심 원리: 메서드가 작업을 수행한 후, 반환값으로 자기 자신의 참조값(this)을 반환한다.
 * - 장점: 코드가 간결해지고, 문맥의 흐름을 연속적으로 읽을 수 있어 가독성이 높아진다.
 */
public class StringMethodChainingEx {
    public static void main(String[] args) {
        /**
         * 1. 체이닝이 없는 경우
         * - 메서드를 호출할 때마다 반환값을 변수에 받거나,
         * - 매번 참조 변수(adder)를 다시 적어줘야 함.
         */
        ValueAdder adder = new ValueAdder();
        adder.add(1);
        adder.add(2);
        adder.add(3);

        int result1 = adder.getValue();
        System.out.println("일반 호출 결과: " + result1);

        /**
         * 2. 메서드 체이닝 적용 (간결함)
         * - add()가 `this`를 반환하므로, `.`을 찍어 바로 다음 메서드를 호출 가능.
         * - "adder에 1을 더하고, (그 결과인 adder에) 2를 더하고, (그 결과에) 3을 더해라"
         */
        ValueAdder adder2 = new ValueAdder();
        int result2 = adder2.add(1).add(2).add(3).getValue();
        System.out.println("체이닝 호출 결과: " + result2);

        /**
         * 3. 대표 사례: StringBuilder
         * - StringBuilder의 append(), insert() 등은 모두 `this`를 반환하도록 설계됨.
         * - 따라서 아래처럼 물 흐르듯이 연속적인 문자열 조작이 가능함.
         */
        StringBuilder sb = new StringBuilder();
        String resultStr = sb.append("A").append("B").append("C").append("D")
                .insert(4, "Java") // 4번 인덱스에 삽입
                .delete(4, 8)      // 4~7번 인덱스 삭제
                .reverse()         // 뒤집기
                .toString();       // 최종적으로 String 변환
        System.out.println("문자열 결과: " + resultStr);
    }
}

class ValueAdder {
    private int value;

    public ValueAdder add(int addValue) {
        value += addValue;
        return this;
    }

    public int getValue() {
        return value;
    }
}
