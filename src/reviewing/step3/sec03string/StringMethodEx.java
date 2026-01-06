package reviewing.step3.sec03string;

/**
 * Java의 주요 String 메서드 정리
 *
 * [참고] CharSequence 인터페이스
 * - String, StringBuilder, StringBuffer의 상위 부모 인터페이스.
 * - 메서드 파라미터로 CharSequence를 받으면, 문자열 종류에 상관없이 모두 처리 가능하여 유연함.
 */
public class StringMethodEx {
    public static void main(String[] args) {
        /**
         * 1. 문자열 정보 조회 (Information)
         */
        System.out.println("--- 1. 문자열 정보 조회 ---");
        String str = "Hello, Java!";
        System.out.println("문자열 길이 (length): " + str.length());
        System.out.println("비어있는가? (isEmpty): " + str.isEmpty()); // 길이 0이면 true
        System.out.println("공백인가? (isBlank): " + "   ".isBlank()); // 길이 0이거나 공백문자만 있으면 true (Java 11+)
        System.out.println("7번 인덱스 문자 (charAt): " + str.charAt(7));

        /**
         * 2. 문자열 비교 (Comparison)
         * - equals: 내용 비교 (boolean)
         * - compareTo: 사전순 비교 (int) -> 같으면 0, 앞서면 음수, 뒤처지면 양수 반환
         */
        System.out.println("\n--- 2. 문자열 비교 ---");
        String str2 = "Hello, Java!";
        String str3 = "hello, java!"; // 소문자
        String str4 = "Hello, World!";

        System.out.println("equals (대소문자 구분): " + str2.equals(str3)); // false
        System.out.println("equalsIgnoreCase (대소문자 무시): " + str2.equalsIgnoreCase(str3)); // true

        System.out.println("compareTo ('b' vs 'a'): " + "b".compareTo("a")); // 1 (양수)
        System.out.println("compareTo (str2 vs str4): " + str2.compareTo(str4)); // 'J' vs 'W' 차이값 반환

        System.out.println("startsWith ('Hello'): " + str2.startsWith("Hello"));
        System.out.println("endsWith ('Java!'): " + str2.endsWith("Java!"));

        /**
         * 3. 문자열 탐색 (Searching)
         * - 못 찾으면 -1 반환
         */
        System.out.println("\n--- 3. 문자열 탐색 ---");
        String str5 = "Hello, Java! Welcome to Java World";
        System.out.println("contains ('Java'): " + str5.contains("Java"));
        System.out.println("indexOf ('Java'): " + str5.indexOf("Java")); // 앞에서부터 찾기
        System.out.println("indexOf ('Java', 10): " + str5.indexOf("Java", 10)); // 10번 인덱스부터 찾기
        System.out.println("lastIndexOf ('Java'): " + str5.lastIndexOf("Java")); // 뒤에서부터 찾기

        /**
         * 4. 문자열 조작 및 부분 추출 (Manipulation)
         * - String은 불변이므로 반환값을 꼭 사용해야 함.
         */
        System.out.println("\n--- 4. 문자열 조작 ---");
        String str6 = "Hello, Java! Welcome to Java World";

        System.out.println("substring (idx 7~끝): " + str6.substring(7));
        System.out.println("substring (idx 7~12): " + str6.substring(7, 12)); // 7이상 12미만
        System.out.println("concat (결합): " + str6.concat("!!!"));

        // replace: 모든 target 문자열 교체
        System.out.println("replace (모두 교체): " + str6.replace("Java", "World"));
        // replaceFirst: 첫 번째 target만 교체 (정규식 사용 가능)
        System.out.println("replaceFirst (첫번째만): " + str6.replaceFirst("Java", "World"));

        /**
         * 5. 문자열 변환 (Transformation)
         */
        System.out.println("\n--- 5. 문자열 변환 ---");
        String str7 = "    Java Programming    ";
        System.out.println("toLowerCase (소문자): " + str7.toLowerCase());
        System.out.println("toUpperCase (대문자): " + str7.toUpperCase());
        // trim(): 아스키 코드 공백(<= U+0020)만 제거 (고전적인 방식)
        System.out.println("trim (공백제거): '" + str7.trim() + "'");
        // strip(): 유니코드 공백까지 모두 제거 (Java 11+, 권장 방식)
        System.out.println("strip (공백제거): '" + str7.strip() + "'");
        System.out.println("stripLeading (앞만): '" + str7.stripLeading() + "'");
        System.out.println("stripTrailing (뒤만): '" + str7.stripTrailing() + "'");

        /**
         * 6. 분할 및 결합 (Split & Join)
         */
        System.out.println("\n--- 6. 분할 및 결합 ---");
        String str8 = "Apple,Banana,Orange";

        // split(): 정규표현식 기준으로 쪼개서 배열로 반환
        String[] splitStr = str8.split(",");
        for (String s : splitStr) {
            System.out.print("[" + s + "] ");
        }
        System.out.println();

        // join(): 구분자를 넣어 결합 (static 메서드)
        String joinStr = String.join("-", "A", "B", "C");
        System.out.println("join (문자열 나열): " + joinStr);

        String joinArr = String.join(" -> ", splitStr);
        System.out.println("join (배열 결합): " + joinArr);

        /**
         * 7. 기타 유틸리티 (Type Conversion & Formatting)
         */
        System.out.println("\n--- 7. 기타 유틸리티 ---");
        int num = 100;
        boolean bool = true;
        Object obj = new Object();

        // valueOf(): 다른 타입을 문자열로 변환 (가장 권장되는 방식)
        System.out.println("valueOf(int): " + String.valueOf(num));
        System.out.println("valueOf(boolean): " + String.valueOf(bool));
        System.out.println("valueOf(Object): " + String.valueOf(obj)); // obj.toString() 호출 결과

        // 문자열 더하기 변환 (편하지만 반복문 사용 시 주의)
        System.out.println("빈 문자열 더하기: " + ("" + num));

        // toCharArray(): 문자열을 char 배열로 변환
        char[] charArray = "Hello".toCharArray();
        System.out.println("toCharArray[0]: " + charArray[0]);

        // format(): 서식 문자열 (printf와 동일한 형식)
        String formatStr = String.format("이름: %s, 점수: %d, 합격: %b", "Kim", 95, true);
        System.out.println("format: " + formatStr);

        // printf(): 콘솔에 직접 출력 (print + format > 개행문자 \n 필요)
        System.out.printf("printf 직접 출력: 실수값 %.2f \n", 10.12345);

        // matches(): 정규표현식 일치 여부 확인
        String regex = "Hello, (Java|World)";
        System.out.println("matches (패턴 일치): " + "Hello, Java".matches(regex));
    }
}
