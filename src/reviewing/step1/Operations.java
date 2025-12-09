package reviewing.step1;

/**
 * Java의 주요 연산자(Operator) 정리
 * - 산술, 증감, 비교, 논리, 대입 연산자의 기본 사용법
 * - 연산자별 특징과 주의사항
 */
public class Operations {
    public static void main(String[] args) {

        /**
         * 1. 산술 연산자 (Arithmetic Operators)
         * 그냥 수학 시간에 배우는 사칙연산이랑 똑같음.
         * +, -, *, /, %
         */
        System.out.println("--- 1. 산술 연산자 ---");
        int firstNum = 5;
        int secondNum = 2;

        // 덧셈 (+)
        int sum = firstNum + secondNum;
        System.out.println(firstNum + " + " + secondNum + " = " + sum); // 7

        // 뺄셈 (-)
        int difference = firstNum - secondNum;
        System.out.println(firstNum + " - " + secondNum + " = " + difference); // 3

        // 곱셈 (*)
        int product = firstNum * secondNum;
        System.out.println(firstNum + " * " + secondNum + " = " + product); // 10

        // 나눗셈 (/)
        int quotient = firstNum / secondNum;
        System.out.println(firstNum + " / " + secondNum + " = " + quotient); // 2
        // int끼리 나누면 결과도 int. 소수점은 그냥 버려짐.

        // 나머지 (%)
        int remainder = firstNum % secondNum;
        System.out.println(firstNum + " % " + secondNum + " = " + remainder); // 1

        // 연산자 우선순위:
        // 상식적으로 생각. 곱셈, 나눗셈이 덧셈, 뺄셈보다 먼저임.
        // 애매하면 그냥 괄호()를 치는 게 정신 건강에 이로움.
        int priorityTest1 = 1 + 2 * 3; // 1 + 6
        int priorityTest2 = (1 + 2) * 3; // 3 * 3
        System.out.println("1 + 2 * 3 = " + priorityTest1); // 7
        System.out.println("(1 + 2) * 3 = " + priorityTest2); // 9

        /**
         * 2. 문자열 연결 (String Concatenation)
         * '+' 연산자는 숫자뿐만 아니라 문자열을 붙이는 데도 씀.
         * 연산 대상 중 하나라도 문자열이면, 나머지도 문자열로 바뀌어서 합쳐짐.
         */
        System.out.println("\n--- 2. 문자열 연결 ---");
        String hello = "Hello, ";
        String world = "World!";
        String helloWorld = hello + world;
        System.out.println(helloWorld); // "Hello, World!"

        // 숫자 100이 문자열 "100"으로 바뀌어서 붙음
        String message = "결과값: " + 100;
        System.out.println(message); // "결과값: 100"


        /**
         * 3. 증감 연산자 (Increment and Decrement Operators)
         * 변수 값을 1씩 올리거나 내리는 연산자.
         * 변수 앞에 붙냐, 뒤에 붙냐에 따라 행동이 달라져서 중요함.
         * ++ (증가), -- (감소)
         */
        System.out.println("\n--- 3. 증감 연산자 ---");
        int counter = 0;

        // 전위(Prefix) 증감: ++counter
        // 일단 내 값부터 증감하고 나서 연산
        int prefixResult = ++counter; // counter를 1로 먼저 올리고, 그 값을 prefixResult에 넣어줌
        System.out.println("전위 연산 후 -> counter: " + counter + ", prefixResult: " + prefixResult); // counter: 1, prefixResult: 1

        // 후위(Postfix) 증감: counter++
        // 다른 연산 다 끝내고, 맨 마지막에 내 값을 증감.
        int postfixResult = counter++; // counter의 현재 값(1)을 postfixResult에 먼저 주고, 그 다음에 counter를 2로 올림
        System.out.println("후위 연산 후 -> counter: " + counter + ", postfixResult: " + postfixResult); // counter: 2, postfixResult: 1


        /**
         * 4. 비교 연산자 (Comparison Operators)
         * 두 값을 비교해서 결과를 true 아니면 false로 알려줌.
         * ==, !=, >, <, >=, <=
         */
        System.out.println("\n--- 4. 비교 연산자 ---");
        int numA = 10;
        int numB = 20;
        System.out.println(numA + " == " + numB + " -> " + (numA == numB)); // false
        System.out.println(numA + " != " + numB + " -> " + (numA != numB)); // true
        System.out.println(numA + " > " + numB + " -> " + (numA > numB));  // false
        System.out.println(numA + " <= " + numB + " -> " + (numA <= numB)); // true

        // 문자열 비교: '=='는 주소(참조) 비교, '.equals()'는 내용(리터럴) 비교
        String strLiteral1 = "Java";
        String strLiteral2 = "Java";
        String strObject = new String("Java"); // new로 만들면 무조건 새 메모리 공간에 초기화

        System.out.println("주소 비교 (==): " + (strLiteral1 == strLiteral2));      // true
        System.out.println("주소 비교 (==): " + (strLiteral1 == strObject));        // false
        System.out.println("내용 비교 (.equals()): " + strLiteral1.equals(strObject)); // true

        /**
         [정리] 문자열 리터럴과 String Constant Pool의 동작 원리

         1.  String은 불변(Immutable) 객체이며 사용 빈도가 매우 높기 때문에,
         JVM은 메모리 효율화를 위해 문자열 리터럴을 'String Constant Pool'이라는 특별한 공간에서 관리한다.

         2.  문자열 리터럴로 변수를 선언하면 (e.g., String s1 = "hello";),
         JVM은 먼저 Pool 안에 동일한 내용의 문자열 인스턴스가 있는지 확인한다.
            없으면: Pool에 새 인스턴스를 생성하고 그 참조(주소)를 변수에 할당한다.
            있으면: 새로 만들지 않고, 기존 인스턴스의 참조(주소)를 그대로 변수에 할당한다.

         3.  이러한 재활용 메커니즘 때문에, 동일한 리터럴을 가리키는 변수들은 결국 같은 주소를 공유한다.
         (e.g., String s1 = "hello"; String s2 = "hello"; 라면 s1 == s2 는 true)

         4.  반면, 'new String("hello")'와 같이 new 키워드를 사용하면 이 규칙이 적용되지 않는다.
         Pool의 인스턴스 존재 여부와 관계없이, 메모리에 무조건 새로운 String 객체를 생성한다.
         따라서 리터럴 변수와 new로 생성한 변수의 주소는 항상 다른 것.
         */

        /**
         * 5. 논리 연산자 (Logical Operators)
         * 여러 개의 true/false 조건을 하나로 합쳐서 최종 결론을 내릴 때 씀.
         * && (AND), || (OR), ! (NOT)
         */
        System.out.println("\n--- 5. 논리 연산자 ---");
        boolean condition1 = true;
        boolean condition2 = false;

        // && (AND): 둘 다 true여야만 true. 하나라도 false면 바로 false. (깐깐한 놈)
        System.out.println(condition1 + " && " + condition2 + " -> " + (condition1 && condition2)); // false

        // || (OR): 하나만 true여도 true. 둘 다 false일 때만 false. (관대한 놈)
        System.out.println(condition1 + " || " + condition2 + " -> " + (condition1 || condition2)); // true

        // ! (NOT): 그냥 결과를 뒤집음. (청개구리)
        System.out.println("!" + condition1 + " -> " + !condition1); // false

        // 활용 예시: 숫자가 특정 범위 안에 있는지 체크할 때 아주 유용함.
        int value = 15;
        boolean isInRange = value > 10 && value < 20; // 10보다 크면서, 동시에 20보다 작은가?
        System.out.println("15는 10과 20 사이에 있는가? " + isInRange); // true


        /**
         * 6. 대입 연산자 (Assignment Operators)
         * 변수에 값을 넣어주는 놈.
         * 다른 연산자랑 합체해서 코드를 짧게 줄일 수 있음.
         * =, +=, -=, *=, /=, %=
         */
        System.out.println("\n--- 6. 대입 연산자 ---");
        int result = 10;

        // result = result + 5; 와 똑같은 코드
        result += 5;
        System.out.println("10 += 5 -> " + result); // 15

        // result = result * 2; 와 똑같은 코드
        result *= 2;
        System.out.println("15 *= 2 -> " + result); // 30
    }
}