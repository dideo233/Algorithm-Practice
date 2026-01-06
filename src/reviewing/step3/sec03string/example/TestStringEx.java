package reviewing.step3.sec03string.example;

/**
 * String 클래스 주요 메서드 활용 실습
 * - startsWith, length, indexOf, substring, trim, replace, split, join
 * - StringBuilder reverse
 */
public class TestStringEx {
    public static void main(String[] args) {
        // [문제 1] startsWith: 특정 문자열로 시작하는지 확인
        String url = "https://www.example.com";
        boolean hasHttps = url.startsWith("https://");
        System.out.println("1. https 시작 여부: " + hasHttps);

        // 문제 2
        // [문제 2] length: 배열 내 모든 문자열 길이의 합 구하기
        System.out.println("\n2. 문자열 길이 합계");
        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
        int totalLength = 0;
        for (String s : arr) {
            System.out.println(s + " : " + s.length());
            totalLength += s.length();
        }
        System.out.println("-> 총 길이: " + totalLength);

        // [문제 3] indexOf: 특정 문자열의 시작 인덱스 찾기
        String fileName = "hello.txt";
        int index = fileName.indexOf(".txt");
        System.out.println("\n3. .txt 인덱스 위치: " + index);

        // [문제 4] substring: 파일명과 확장자 분리하기 (동적 파싱)
        // 하드코딩(숫자 직접 입력)보다는 indexOf로 위치를 찾아 자르는 것이 안전함.
        String file = "hello.txt";
        String ext = ".txt";

        int extIndex = file.indexOf(ext);
        String name = file.substring(0, extIndex); // 0부터 . 앞까지
        String extension = file.substring(extIndex); // . 부터 끝까지

        System.out.println("\n4. 파일명: " + name);
        System.out.println("   확장자: " + extension);

        // [문제 5] 검색: 특정 단어("hello")가 몇 번 등장하는지 카운트
        String str = "start hello java, hello spring, hello jpa";
        String key = "hello";
        int count = 0;
        int searchIndex = str.indexOf(key);

        while (searchIndex != -1) {
            count++;
            // 찾은 위치 다음(+1)부터 다시 검색
            searchIndex = str.indexOf(key, searchIndex + 1);
        }
        System.out.println("\n5. 'hello' 등장 횟수: " + count);

        // [문제 6] trim: 앞뒤 공백 제거
        String original = "   Hello java   ";
        String trimmed = original.trim();
        System.out.println("\n6. 공백 제거 결과: '" + trimmed + "'");

        // [문제 7] replace: 문자열 치환 (java -> jvm)
        String input = "hello java spring jpa java";
        String replaced = input.replace("java", "jvm");
        System.out.println("\n7. 치환 결과: " + replaced);

        // [문제 8] split: 이메일 ID와 도메인 분리
        String email = "hello@example.com";
        String[] parts = email.split("@");
        System.out.println("\n8. ID: " + parts[0]);
        System.out.println("   Domain: " + parts[1]);

        // [문제 9] split & join: 분리 후 구분자 변경하여 합치기
        String fruits = "apple,banana,mango";
        String[] splitFruits = fruits.split(",");
        String joinedFruits = String.join("->", splitFruits);
        System.out.println("\n9. 결합 결과: " + joinedFruits);

        // [문제 10] reverse: 문자열 뒤집기 (StringBuilder 활용)
        String str3 = "Hello java";
        String reversed = new StringBuilder(str3).reverse().toString();
        System.out.println("\n10. 뒤집기 결과: " + reversed);

    }
}