package reviewing.step2.sec04constructor;

public class MemberConstructor {
    String name;
    int age;
    int grade;

    public MemberConstructor() {}
    public MemberConstructor(String name, int age) {
        this(name, age, 0);
    }
    public MemberConstructor(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
