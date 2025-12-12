package reviewing.step2.sec08Inheritance.access;

public class Child extends Parent {

    public void call() {
        // 값 변경 시도
        publicValue = 1;
        protectedValue = 1; // 상속 관계 or 같은 관계
        defaultValue = 1;   // 같은 패키지(access)이므로 접근 가능

        // 불가능. private은 부모 클래스 내부에서만 접근 가능
        // privateValue = 1; 

        System.out.println("Child > Parent private 접근");
        printParent(); // 부모 메서드를 통해 확인
    }

}
