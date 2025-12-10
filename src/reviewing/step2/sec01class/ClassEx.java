package reviewing.step2.sec01class;

/**
 * Java의 클래스(Class) 기본 정리
 * - 기본 개념, 객체 생성 및 사용법 등
 */
public class ClassEx {

    /*
    [이론 1] 클래스(Class)는 왜 필요한가?
    - 클래스가 없다면, 학생 한 명의 정보를 관리하기 위해 이름/나이/성적 배열을 각각 만들어야 함.
      (e.g., String[] names, int[] ages, int[] grades)
      -> 특정 학생의 정보를 찾아 수정하기 매우 번거롭고 실수하기 쉬움.

    - 클래스는 연관된 데이터(속성)와 기능(메서드)을 하나로 묶어 다루는 '사용자 정의 데이터 타입'을 만드는 설계도.
    - 이 설계도를 통해, 논리적으로 관련된 데이터를 하나의 단위(객체)로 깔끔하게 관리할 수 있음.

    [이론 2] 클래스와 객체(Object), 그리고 인스턴스(Instance)
    - 클래스 (Class): 객체를 만들어내기 위한 명세. 메모리에 실체가 없음.
    - 객체 (Object): 클래스라는 설계도를 바탕으로, `new` 키워드를 통해 메모리에 실제로 만들어진 '실체'.
    - 인스턴스 (Instance): 특정 클래스로부터 만들어진 객체임을 강조할 때 사용하는 용어. (e.g., "student1은 Student 클래스의 인스턴스다.")
      -> 객체와 인스턴스는 거의 같은 의미로 사용되므로, 크게 신경 쓸 필요 없음.

    - 핵심: 모든 객체는 독립된 메모리 공간을 가지므로, 서로의 데이터에 영향을 주지 않음.

    [기타] static 키워드란?
    - '정적인', '고정된' 이라는 의미로, 클래스 자체에 소속되는 멤버(변수, 메서드)를 만들 때 사용.
    - 특징:
      1. 객체를 생성(`new`)하지 않아도, '클래스명.멤버명' 형태로 바로 접근 가능.
      2. 프로그램 시작 시 클래스가 메모리에 올라갈 때, static 영역에 단 한 번 생성됨.
      3. 모든 객체가 이 static 멤버를 공유함.
    - 용도:
      - 모든 객체가 공통적으로 사용하는 값 (e.g., `Math.PI`)
      - 객체 생성과 무관하게 사용해야 하는 유틸리티(helper) 메서드 (e.g., `main` 메서드)
      - 싱글톤 패턴 등 특정 디자인 패턴 구현
    */

    public static void main(String[] args) {

        /**
         * 1. 객체 생성 (Object Creation)
         * - 문법: `클래스명 변수명 = new 클래스명();`
         * - `new Student()`: Student 클래스 설계도를 기반으로 메모리에 학생 객체를 실제로 생성(new)
         */
        System.out.println("--- 1. 객체 생성 및 사용 ---");
        Student student1 = new Student(); // Student 클래스의 인스턴스(객체) 생성
        Student student2 = new Student(); // 또 다른 독립된 인스턴스(객체) 생성

        /**
         * 2. 필드 접근 및 값 할당 (Field Access)
         * - `.` (점, dot) 연산자: 참조 변수가 저장한 메모리 주소로 찾아가, 해당 객체의 내부에 접근하는 역할을 함.
         */
        // student1 객체의 필드에 값 할당
        student1.name = "홍길동";
        student1.age = 17;
        student1.grade = 90;

        // student2 객체의 필드에 값 할당
        student2.name = "임꺽정";
        student2.age = 18;
        student2.grade = 85;

        // 각 객체의 필드 값을 출력. 서로 다른 값을 가지고 있음을 확인.
        System.out.println("이름: " + student1.name + ", 나이: " + student1.age + ", 성적: " + student1.grade);
        System.out.println("이름: " + student2.name + ", 나이: " + student2.age + ", 성적: " + student2.grade);

        /**
         * 3. 객체 배열 활용 (Array of Objects)
         * - 클래스(Student)도 하나의 타입이므로, 이 타입의 객체들을 담는 배열을 만들 수 있음.
         */
        System.out.println("\n--- 2. 객체 배열 활용 ---");

        // Student 객체 2개를 담을 수 있는 배열 생성 및 초기화
        Student[] students = {student1, student2};

        // 향상된 for문(for-each)을 사용하여 배열의 모든 학생 정보를 순회하며 출력
        for (Student s : students) {
            System.out.println("이름: " + s.name + ", 나이: " + s.age + ", 성적: " + s.grade);
        }
    }
}
