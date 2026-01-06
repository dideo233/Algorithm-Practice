package reviewing.step3.sec03string;

/**
 * 1. String의 단점과 StringBuilder 필요성
 * - String(불변) 클래스는 문자를 더하거나 변경할 때마다 새 객체를 생성해야 함 (성능/메모리 낭비)
 * - StringBuilder(가변) 클래스는 하나의 객체 안에서 원본을 직접 수정하여 빠르고 효율적임 (+ 메서드 체이닝 지원).
 *
 * [결론] 문자열 추가/변경이 잦은 경우(특히 반복문)에는 StringBuilder를 사용하고,
 *       작업이 끝나면 toString()을 통해 String으로 변환한다.
 */
public class StringMutableEx {
    public static void main(String[] args) {
        // 1. 생성 및 추가 (Append)
        // 가변 객체이므로 내부 값이 직접 변경됨
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println("append 결과: " + sb);

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
