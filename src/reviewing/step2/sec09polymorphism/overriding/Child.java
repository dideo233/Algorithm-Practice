package reviewing.step2.sec09polymorphism.overriding;

public class Child extends Parent {
    public String value = "child";

    @Override
    public void method() {
        System.out.println("Child.method");
    }

}
