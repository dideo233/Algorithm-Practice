package reviewing.step3.sec03string;

/**
 * 1. String의 불변성(Immutability)
 * - String은 한 번 생성되면 내부 값을 변경할 수 없음.
 * - 변경 메서드(concat 등)는 원본을 냅두고 '새로운 객체'를 반환함.
 *
 * 2. 불변으로 설계된 이유
 * - String은 메모리 효율을 위해 '문자열 풀'에서 여러 변수가 값을 공유함.
 * - 만약 변경이 가능하다면, 변수 A를 수정했는데 공유하던 변수 B, C까지
 *   덩달아 값이 바뀌는 심각한 사이드 이펙트(부작용)가 발생하기 때문.
 */
public class StringImmutableEx {
    public static void main(String[] args) {
        // 1. 불변 객체의 특징
        String str1 = "hello";
        str1.concat(" world"); // 반환값을 안 받으면 그냥 버려짐
        System.out.println("str1 = " + str1); // "hello" (원본은 안 변함)

        // 2. 값을 변경하려면 (반환값 수신 필수)
        String str2 = str1.concat(" world");
        System.out.println("str2 = " + str2); // "hello world"

        /**
         * [참고]
         * - String의 불변성은 값을 더할 때마다 새 객체가 생성되게 함 (성능/메모리 낭비)
         * - StringBuilder의 장점: 가변(Mutable)이라 원본을 직접 수정하여 빠르고 효율적임 (+ 메서드 체이닝 지원).
         * - 결론: 문자열 추가/변경 연산이 많거나, 특히 반복문 안에서는 String 대신 StringBuilder 필수.
         */
    }
}
