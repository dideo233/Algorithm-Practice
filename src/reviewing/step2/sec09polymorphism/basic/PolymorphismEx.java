package reviewing.step2.sec09polymorphism.basic;

public class PolymorphismEx {

    /**
     * [이론]
     * 1. 다형성
     * - 하나의 객체가 여러 타입으로 쓰일 수 있는 특성 (핵심; 다형적 참조, 메서드 오버라이딩)
     *
     * 2. 다형적 참조
     * - 부모 타입 변수는 자식 인스턴스를 참조할 수 있다. (Parent p = new Child())
     * - 반대는 불가 (Child c = new Parent() X)
     *
     * 3. 캐스팅
     * - 다형적 참조 시 "참조하는 변수의 타입"을 변경하여 바라보는 범위를 조절하는 것 (인스턴스의 타입 변경 X)
     *   - 업캐스팅(Upcasting): 자식 -> 부모 (생략 가능, 안전함)
     *   - 다운캐스팅(Downcasting): 부모 -> 자식 (명시적 필수, 위험 감수)
     */

    /**
     * [왜 필요한가?]
     * - 평소에는 Parent로 일반화해서 다루다가(다형성), 특정 순간에만 자식의 구체적 기능이 필요할 때 '잠깐' 꺼내 쓰기 위함
     * [Child로만 써도 되는 거 아닌가?]
     * - 확장성과 관리의 편의성 때문. 
     *   예: 차가 100종류여도 Car[] 배열 하나로 관리 가능 vs Child로만 쓰면 배열 100개 필요
     * [사용 케이스]
     * - 부모 타입: 여러 종류의 객체를 한 번에 묶어서 관리하고 싶을 때. 새로운 기능 추가에 유연하게 대응하고 싶을 때.
     *   핵심: "공통 기능(move)"만 호출해도 충분할 때.
     * - 자식 타입: 해당 자식의 매우 구체적인 기능을 집중적으로 써야 하는 로직일 때.
     */

    public static void main(String[] args) {

        // 1. 기본 참조 (부모 > 부모, 자식 > 자식)
        System.out.println("[1.1.기본 참조] Parent > Parent");
        Parent parent1 = new Parent();
        parent1.parentMethod(); //Parent 인스턴스 생성 (메모리 상 Parent만 존재)

        System.out.println("[1.2.기본 참조] Child > Child");
        Child child1 = new Child();
        child1.parentMethod();
        child1.childMethod(); //Child 인스턴스 생성 (메모리 상 Child와 Parent 존재)

        System.out.println();

        // 2. 다형적 참조 (Parent > Child)
        System.out.println("[2.다형적 참조] Parent > Child");
        Parent parent2 = new Child();
        parent2.parentMethod(); // 변수 타입은 1.1(Parent)이되, 인스턴스는 1.2(Child)라서 메모리에 둘 다 존재함.

        // 3. 다형적 참조의 한계
        // poly.childMethod(); // 컴파일 에러 발생!
        /**
         * [왜 호출할 수 없는가?]
         * 1. 메서드 호출 시, 호출하는 변수의 타입(Parent)을 기준으로 탐색을 시작함.
         * 2. Parent 클래스에는 childMethod()가 없음.
         * 3. 상속 관계에서 탐색은 자식 -> 부모(위쪽)로만 가능함.
         * 4. 부모 타입에서 자식(아래쪽)으로는 내려갈 수 없음. (시야 제한)
         * 결론: 메모리에 Child 인스턴스가 실존하더라도, Parent 타입으로는 Child 기능을 볼 수 없다.
         */

        System.out.println();

        // [여기까지 현재 상황]
        // - poly는 실제 메모리에 Child 기능을 가지고 있음. (2. 다형적 참조)
        // - 하지만 변수 타입이 Parent라서 시야가 제한됨 (Child 기능이 안 보임). (3. 다형적 참조의 한계)

        // 4. 다형성과 다운캐스팅 (해결)
        System.out.println("[3.다운캐스팅] Parent 타입을 Child 타입으로 변경");

        Child downcastingChild = (Child) parent2; // (Child)로 타입을 강제 변경(캐스팅)
        downcastingChild.childMethod();        // 이제 Child 타입으로 보니까 기능이 보임!

        /**
         * [해설]
         * - 인스턴스(객체) 자체를 바꾸는 게 아님 (메모리 상의 객체는 그대로).
         * - 단지 그 객체를 바라보는 '시야(참조 변수의 타입)'을 변경한 것.
         * - 즉, Parent 안경을 벗고 Child 안경으로 바꿔 써서, 가려졌던 기능을 다시 보는 과정.
         */

        System.out.println();

        // 5. 캐스팅의 안전성과 주의점 (업캐스팅 vs 다운캐스팅)
        System.out.println("[4. 캐스팅의 안전성과 주의점]");

        // 5.1. 업캐스팅: 생략 가능, 언제나 안전
        Child child2 = new Child();
        Parent parent3 = child2; // (Parent) 생략됨
        parent3.parentMethod();

        // 5.2. 다운캐스팅: 명시적 필수, 조건부 안전
        // 부모 변수지만, 실제로는 '자식 인스턴스'를 담고 있는 경우 (성공)
        System.out.println("\n[성공] 자식 품은 부모 -> 다운캐스팅");
        Child child3  = (Child) parent3;
        child3.childMethod(); // 문제 없음.

        // 진짜 '부모 인스턴스'인 경우 (실패)
        System.out.println("[실패] 진짜 부모 -> 다운캐스팅 실패 (ClassCastException)");
        Parent parent4 = new Parent();
        //Child child4 = (Child) parent4; // 런타임 에러 발생

        /**
         * [실패 원인]
         * - 'new Parent()'는 메모리에 부모 인스턴스만 생성하고, 자식(Child)은 없음.
         * - 없는 공간을 사용하려고 강제로 캐스팅하니, 실행 중(Runtime)에 에러 발생.
         *
         * [업캐스팅이 안전하고 다운캐스팅이 위험한 이유]
         * new A, B, C 가정 (C extends B, B extends A)
         * - new C해서 업캐스팅하면 B, A 있어서 문제 없음 (메모리에 상위 타입 부모 다 생성)
         * - new B는 A와 B까지만 생성함. C로 다운캐스팅하면 런타임 에러
         *   (대입 시도하면 대입 불가하여 컴파일 오류, 강제 다운캐스팅하면 실행은 되나 런타임 오류 발생)
         *
         * [참고: 컴파일 오류 vs 런타임 오류]
         * - 컴파일: 프로그램 실행 전 발생 가능 오류. 문법이 틀려서 아예 실행 파일 생성이 안 됨. (미연에 식별)
         * - 런타임: 프로그램 실행 후 발생하는 오류. 문법은 맞지만, 실행 도중 메모리 구조 등이 안 맞아서 뻗음 (식별 안 되니 더 나쁜 오류)
         */

        System.out.println();

        //5. 인스턴스 확인 (instanceof)
        /**
         * 객체가 특정 클래스에 속하는지 아닌지를 확인하는 키워드
         * [문법] object instanceof Type
         *  > object가 Type의 인스턴스이거나, 그 하위 타입인지 확인 (true/false)
         *
         * [판별표 (A instanceof B)]
         * - new Parent() instanceof Parent > true
         * - new Child()  instanceof Parent > true (자식은 부모의 하위)
         * - new Parent() instanceof Child  > false (부모는 자식의 하위 아님)
         * - new Child()  instanceof Child  > true
         */

        System.out.println("[5. instanceof Child 테스트]");

        System.out.println("[Parent 객체 전달]");
        Parent parent5 = new Parent();
        call(parent5);

        System.out.println("\n[Child 객체 전달]");
        Parent parent6 = new Child();
        call(parent6);
    }

    public static void call(Parent parent){
        if(parent instanceof Child child){ // Java 16 문법
            System.out.println("Child 인스턴스 맞음");
            child.childMethod();
        } else {
            System.out.println("Child 인스턴스 아님");
        }
    }
}
