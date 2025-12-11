package reviewing.step2.sec01class;

/**
 * Java의 클래스(Class)와 객체(Object) 기초
 * - 클래스의 필요성, 객체 생성 과정
 * - 변수의 종류와 메모리 구조, static 키워드
 */
public class ClassEx {

    /**
     * 핵심 개념
     * 1. 클래스(Class)의 필요성
     *    - 문제점: 학생 한 명의 정보(이름, 나이, 성적)를 배열로 관리하면, 데이터가 흩어져서 관리하기 힘듦.
     *    - 해결책: 연관된 데이터를 하나로 묶는 '사용자 정의 타입(설계도)'을 만듦.
     *
     * 2. 용어 정리
     *    - 클래스 (Class): 객체를 만들기 위한 '설계도' (붕어빵 틀). 메모리에 실체 없음.
     *    - 객체 (Object): 설계도를 통해 메모리(Heap)에 실제로 생성된 '실체' (붕어빵).
     *    - 인스턴스 (Instance): 특정 클래스 소속임을 강조할 때 쓰는 말. (객체와 거의 같은 의미)
     *
     * 3. 변수의 종류와 메모리
     *    - 인스턴스 변수: 객체마다 다르게 가지는 값 (이름, 나이). 'Heap 영역'에 생성.
     *    - 클래스(static) 변수: 모든 객체가 공유하는 값. 'Method 영역'에 생성.
     */

    public static void main(String[] args) {

        /**
         * 1. 객체 생성 (Object Creation)
         * - 문법: 클래스명 변수명 = new 클래스명();
         * - `new`: 설계도(Class)를 보고 메모리(Heap)에 실제 공간을 만들라는 명령어.
         */
        System.out.println("--- 1. 객체 생성 및 사용 ---");
        Student student1 = new Student(); // Student 클래스의 인스턴스(객체) 생성
        Student student2 = new Student(); // 또 다른 독립된 인스턴스(객체) 생성

        /**
         * 2. 필드 접근 및 값 할당 (Field Access)
         * - `. (dot)` 연산자: "이 변수가 가리키는 주소로 가서~" 라는 뜻.
         */
        student1.name = "홍길동";
        student1.age = 17;
        student1.grade = 90;

        student2.name = "임꺽정";
        student2.age = 18;
        student2.grade = 85;

        // 출력: 각 객체는 서로 다른 메모리 공간을 쓰므로 값이 섞이지 않음.
        System.out.println("이름: " + student1.name + ", 나이: " + student1.age + ", 성적: " + student1.grade);
        System.out.println("이름: " + student2.name + ", 나이: " + student2.age + ", 성적: " + student2.grade);

        /**
         * 3. 객체 배열 (Array of Objects)
         * - 클래스도 자료형이므로 배열로 묶어서 관리 가능.
         * - 주의: 객체 자체가 배열에 들어가는 게 아니라, 객체의 '주소(참조값)'가 들어감.
         */
        System.out.println("\n--- 2. 객체 배열 활용 ---");

        Student[] students = {student1, student2};

        for (Student s : students) {
            System.out.println("이름: " + s.name + ", 나이: " + s.age + ", 성적: " + s.grade);
        }
    }
}
