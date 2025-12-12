package reviewing.step2.sec08Inheritance.superthis;

public class ChildThis extends ParentSuper{
    public String value = "child"; //부모 필드와 동일 value (Shadowing)

    // 기본 생성자
    public ChildThis(){
        // super(); // 생략되어 있지만, 부모 기본 생성자가 가장 먼저 호출됨
        System.out.println("ChildThis()");
    }

    // 파라미터가 있는 생성자
    public ChildThis(int a,int b){
        super(); // 부모 생성자 명시적 호출 (첫 줄 원칙)
        System.out.println("ChildThis(a, b)");
    }

    @Override
    public void hello(){
        System.out.println("Child hello() 실행");
    }

    public void callSuper() {
        System.out.println("\n--- 변수(Field) 참조 비교 ---");
        System.out.println("this.value   : " + this.value);
        System.out.println("super.value  : " + super.value);

        System.out.println("\n--- 메서드(Method) 호출 비교 ---");
        System.out.print("this.hello() > ");
        this.hello();

        System.out.print("super.hello() > ");
        super.hello();
    }
}
