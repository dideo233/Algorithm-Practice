package reviewing.step3.sec05enum.ex02typesafe;

/**
 * 타입 안전 열거형 패턴 구현 클래스
 * - static final 상수로 객체를 미리 생성해둠.
 * - 생성자를 private으로 막아 외부 생성을 차단함.
 */
public class ClassGrade {

    public static final ClassGrade BASIC = new ClassGrade();
    public static final ClassGrade GOLD = new ClassGrade();
    public static final ClassGrade DIAMOND = new ClassGrade();

    private ClassGrade() {}

}
