package reviewing.step3.sec04wrapper.example;

public class TextWrapperEx {

    public static void main(String[] args) {
        // 문제 1: 문자열을 정수(int)로 변환하여 합계 구하기
        String str1 = "10";
        String str2 = "20";

        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        int intSum = num1 + num2;
        System.out.println("두 수의 합 = " + intSum);

        // 문제 2: 문자열 배열의 값들을 실수(double)로 변환하여 합계 구하기
        String[] array = {"1.5", "2.5", "3.5"};

        double doubleSum = 0;
        for (String s : array) {
            double d = Double.parseDouble(s);
            doubleSum += d;
        }
        System.out.println("\n여러 수의 합: " + doubleSum);

        // 문제 3: 수동 박싱(Boxing)과 언박싱(Unboxing)
        String str3 = "100";

        Integer integer1 = Integer.valueOf(str3); // 박싱: String -> Integer 객체
        int intValue1 = integer1.intValue();      // 언박싱: Integer 객체 -> int 기본형
        System.out.println("\ninteger1(박싱): " + integer1);
        System.out.println("intValue1(언박싱): " + intValue1);

        // 문제 4: 오토 박싱(Auto-boxing)과 오토 언박싱(Auto-unboxing)
        String str4 = "100";

        Integer integer3 = Integer.parseInt(str4); // 오토 박싱: parseInt(int) 반환값을 Integer 객체에 바로 대입
        int intValue2 = integer3;                  // 오토 언박싱: Integer 객체를 int 변수에 바로 대입
        System.out.println("\ninteger3(오토박싱): " + integer3);
        System.out.println("intValue2(오토언박싱): " + intValue2);

        // 문제 5: 로또 번호 생성기 실행
        LottoGenerator lottoGenerator = new LottoGenerator();
        int[] lottoNumbers = lottoGenerator.generate();

        System.out.print("\n로또 번호: ");
        for (int number : lottoNumbers) {
            System.out.print(number + " ");
        }
    }
}