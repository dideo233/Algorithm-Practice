
package reviewing.step3.sec04wrapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class 클래스와 리플렉션 (Reflection)
 *
 * 1. Class 클래스 (메타데이터 저장소)
 * - 실행 중인 자바 애플리케이션의 클래스, 인터페이스 등의 정보(이름, 필드, 메서드 등)를 다룸.
 * - 즉, '클래스의 클래스' (클래스 설명서) 역할.
 *
 * 2. 리플렉션 (Reflection)
 * - Class 객체에 저장된 메타 정보를 활용하여, 실행 중에(Runtime) 객체를 생성하거나 메서드를 호출하는 기술. (동적 로딩과 생성)
 *   이를 통해 객체 인스턴스를 생성하거나 메서드를 직접 호출하여 조작하는 작업.
 * - 주로 프레임워크(Spring, JUnit 등)에서 개발자가 작성한 코드를 동적으로 분석하고 실행할 때 사용됨.
 *
 * [주요 기능 상세]
 *   - 타입 정보 조회: 클래스명, 슈퍼클래스, 인터페이스, 접근 제한자 정보 조회.
 *   - 리플렉션 활용: 클래스 내 필드, 메서드, 생성자를 조회하고, 이를 통해 객체 생성 및 메서드 조작.
 *   - 어노테이션 처리: 클래스에 적용된 어노테이션을 조회하고 처리하는 기능 제공.
 */
public class ClassMetaEx {
    public static void main(String[] args) throws Exception {

        // 1. Class 객체 조회 (3가지 방법)
        Class clazz = String.class;                         // 클래스 리터럴 사용 (가장 일반적)
        // Class clazz = new String().getClass();           // 인스턴스의 getClass() 메서드 사용
        // Class clazz = Class.forName("java.lang.String"); // 문자열 이름으로 조회 (동적 로딩)

        // 2. 필드 및 메서드 정보 조회 (Reflection)
        // Class 객체를 통해 내부 구조(필드, 메서드, 부모 등)를 들여다볼 수 있음.
        System.out.println("--- 필드 & 메서드 정보 ---");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field.getType().getSimpleName() + " " + field.getName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < Math.min(methods.length, 3); i++) {
            System.out.println("Method: " + methods[i].getName());
        }

        // 3. 상속 및 인터페이스 정보
        System.out.println("\n--- 상속 관계 ---");
        System.out.println("SuperClass: " + clazz.getSuperclass().getName());
        for (Class i : clazz.getInterfaces()) {
            System.out.println("Interface: " + i.getSimpleName());
        }

        // 4. 동적 객체 생성 및 메서드 호출
        // 코드로 'new ClassHello()'를 쓰지 않고, Class 정보만으로 객체를 생성함
        System.out.println("\n--- 리플렉션을 통한 동적 객체 생성 ---");
        Class helloClass = ClassHello.class;
        ClassHello hello = (ClassHello) helloClass.getDeclaredConstructor().newInstance();  // 기본 생성자를 찾아서 호출
        System.out.println("Result: " + hello.hello());

        // [활용] 문자열로 된 클래스 이름만 입력받아도 해당 기능을 실행하는 유연한 코드를 짤 수 있음.
    }
}

class ClassHello {
    public String hello() {
        return "hello";
    }
}
