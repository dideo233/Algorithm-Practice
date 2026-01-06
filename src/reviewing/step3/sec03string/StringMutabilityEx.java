package reviewing.step3.sec03string;

/**
 * String의 불변성(Immutable) vs StringBuilder의 가변성(Mutable)
 *
 * 1. String의 불변성
 * - String은 한 번 생성되면 내부 값을 변경할 수 없음.
 * - 값을 바꾸는 연산(concat 등)은 원본을 수정하는 게 아니라 '새로운 객체'를 반환함.
 *
 * 2. 불변으로 설계된 이유
 * - String은 메모리 효율을 위해 '문자열 풀'에서 여러 변수가 값을 공유함.
 * - 만약 변경이 가능하다면, 변수 A를 수정했는데 공유하던 변수 B, C까지
 *   덩달아 값이 바뀌는 심각한 사이드 이펙트(부작용)가 발생하기 때문.
 *
 * 3. String의 단점과 StringBuilder 필요성
 * - String 클래스는 문자를 더하거나 변경할 때마다 새 객체를 생성해야 함 (성능/메모리 낭비)
 * - StringBuilder 클래스는 하나의 객체 안에서 원본을 직접 수정하여 빠르고 효율적임 (+ 메서드 체이닝 지원)
 *
 * [결론] 문자열 추가/변경이 잦은 경우에는 StringBuilder를 사용하고,
 *       작업이 끝나면 toString()을 통해 String으로 변환한다.
 */
public class StringMutabilityEx {
    public static void main(String[] args) {

        /**
         * String의 불변성
         */
        // 1. 불변 객체의 특징
        String str1 = "hello";
        str1.concat(" world"); // 반환값을 안 받으면 그냥 버려짐
        System.out.println("str1 = " + str1); // "hello" (원본은 안 변함)

        // 2. 값을 변경하려면 (반환값 수신 필수)
        String str2 = str1.concat(" world");
        System.out.println("str2 = " + str2); // "hello world"
        
        /**
         * StringBuilder 사용
         */
        // 1. 생성 및 추가 (Append)
        // 가변 객체이므로 내부 값이 직접 변경됨
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println("\nappend 결과: " + sb);

        // 2. 삽입 (Insert)
        // 4번 인덱스 위치에 문자열 끼워 넣기
        sb.insert(4, "Java");
        System.out.println("insert 결과: " + sb);

        // 3. 삭제 (Delete)
        // 4번부터 8번 직전까지 삭제
        sb.delete(4, 8);
        System.out.println("delete 결과: " + sb);

        // 4. 뒤집기 (Reverse)
        sb.reverse();
        System.out.println("reverse 결과: " + sb);

        // 5. String으로 변환 (toString)
        // 문자열 조작이 끝나면 안전한 불변 객체(String)로 변환하여 사용
        String finalString = sb.toString();
        System.out.println("최종 변환: " + finalString);
    }
}
