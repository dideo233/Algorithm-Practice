package reviewing.step2.sec08Inheritance;

import reviewing.step2.sec08Inheritance.example.ElectricCar;
import reviewing.step2.sec08Inheritance.example.GasCar;
import reviewing.step2.sec08Inheritance.superthis.ChildThis;

public class ExtendEx {

    /**
     * [이론]
     * 1. 상속이란?
     *  - 기존 클래스(부모)의 특성을 자식 클래스가 물려받아 재사용/확장하는 기능 (is-a 관계)
     *  - extends 키워드를 사용하며, 단일 상속만 지원 (하나의 부모 클래스만 상속 가능)
     *  - 부모에 공통 기능, 자식에 전용 기능 배치하여 중복 제거(코드 재사용) + 확장 가능한 구조
     *  - 단일 상속의 이유:
     *    다중 상속 시 여러 부모에 동일한 메서드가 있을 경우 모호성 발생
     *    계층 구조가 복잡해져 유지보수가 어려움 (다이아몬드 문제)
     *
     * 2. 오버라이딩이란?
     * - 부모 클래스로부터 상속받은 메서드를 자식 클래스의 특성에 맞게 재정의하는 것
     * - 규칙:
     *   - 메서드 시그니처(이름, 매개변수, 반환 타입)가 완전히 동일해야 함
     *   - 접근 제어자는 부모보다 넓거나 같아야 함 (protected > public 가능, 반대 불가)
     *   - 체크 예외는 부모보다 많이 던질 수 없음
     *     부모가 IOException만 던지면, 자식은 IOException + SQLException 불가
     *     이유: Parent 타입으로 참조 시 예상치 못한 예외 발생 방지
     *   - static(클래스 레벨 작동), final(재정의/상속 금지), private(클래스 외부에 가려짐) 메서드는 오버라이딩 불가
     *   - @Override 애노테이션으로 오버라이딩 규칙 준수 여부를 컴파일러 검증 받는 것을 강력 권장 (오타/실수 방지)
     *
     * 3. 오버라이딩과 오버로딩과의 차이:
     *   - 오버라이딩: 상속 관계에서 같은 시그니처를 "재정의" (수직 관계)
     *   - 오버로딩: 같은 클래스 내에서 이름만 같고 매개변수 다른 메서드 "추가" (수평 관계)

     /**
     * [용어 정리]
     * - 부모 클래스(슈퍼 클래스): 상속을 제공하는 클래스
     * - 자식 클래스(서브 클래스): 상속을 받는 클래스
     * - super:상속된 부모 클래스의 참조값을 가리키는 키워드
     * - 쉐도잉(Shadowing): 자식 클래스에서 부모와 같은 이름의 필드를 정의하여 부모의 필드를 가리는 현상
     */

    public static void main(String[] args) {
        // 1. 상속과 메서드 오버라이딩
        System.out.println("========== 1. Car 상속 테스트 ==========");
        /**
         * [상속과 메모리 구조]
         * 1. 인스턴스 생성
         *   - 겉으로는 하나의 인스턴스만 생성되지만, 내부적으로는 부모와 자식 클래스의 인스턴스가 모두 생성됨
         *   - 하나의 참조값으로 접근하되, 메모리 내부에서는 부모와 자식 영역이 구분되어 존재 (자식의 부모 호출은, 부모 입장에서는 외부 호출)
         * 2. 메서드 호출 메커니즘
         *   - 메모리 내부에 부모와 자식 클래스가 모두 존재하므로, 메서드 호출 시 어느 클래스의 메서드를 실행할지 결정해야 함
         *   - 호출 시작점: 변수의 타입(선언된 클래스)부터 메서드 탐색 시작
         *     예) Parent p = new Child(); → Parent 타입부터 탐색
         *   - 탐색 순서:
         *     변수 타입이 자식 클래스인 경우: 자식 > 부모 순으로 탐색
         *     변수 타입이 부모 클래스인 경우: 부모에서만 탐색
         *     (메서드를 찾지 못하면 컴파일 오류 발생)
         * 3. 오버라이딩 메서드:
         *   - 메서드 호출 시 자식 클래스에서 먼저 탐색 > 오버라이딩된 메서드 있을 시 우선 실행됨
         *   - 부모의 원본 메서드는 가려지지만(shadowing), super 키워드로 접근 가능
         *   - 이것이 가능한 이유: 메모리에 부모+자식 인스턴스가 모두 존재하기 때문
         */
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();

        System.out.println();

        // 2. super와 this 키워드 (참조의 차이)
        System.out.println("========== 2. Super / This 참조 테스트 ==========");
        /**
         * [필드 쉐도잉과 접근]
         * - 상속 관계에서 부모와 자식에 같은 이름의 필드가 있을 때, 변수 타입(선언된 타입)에 따라 접근되는 필드가 결정됨 (필드 쉐도잉)
         *   예) Parent p = new Child(); p.name 시 Parent의 name
         *       Child c = new Child(); c.name 시 Child의 name
         * - 가려진 부모 요소는 super 키워드로 명시적 접근 가능
         * - 메서드 오버라이딩과 다른 점: 메서드는 실제 인스턴스 타입에 따라 실행됨 (다형성)
         *   예) Parent p = new Child(); p.method() 시 Child의 오버라이딩된 메서드 실행 (선언형 vs 인스턴스)
         */
        ChildThis childThis = new ChildThis();
        childThis.callSuper(); // this.value vs super.value 비교

        System.out.println();

        // 3. 생성자 호출 순서 (Constructor Chaining)
        /**
         * [생성자 호출 메커니즘]
         * 1. 자식 객체 생성 시 자식 생성자 호출
         * 2. 자식 생성자 첫 줄에는 반드시 super() (부모 생성자)가 있어야 함 (부모 부분을 초기화하기 위함)
         * 3. 따라서 실제 실행 순서는: 부모 생성자 완료 -> 자식 생성자 완료
         * (this()로 자신의 다른 생성자를 호출한다 해도, 결국 마지막엔 super()를 타게 됨)
         */
        System.out.println("========== 3. 생성자 호출 순서 테스트 ==========");
        ChildThis childThis2 = new ChildThis(10, 20);



    }
}
