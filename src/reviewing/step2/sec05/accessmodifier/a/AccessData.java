package reviewing.step2.sec05.accessmodifier.a;

public class AccessData {
    public int publicField;      // 누구나
    int defaultField;            // 같은 패키지(a)끼리만
    private int privateField;    // 나(AccessData)만

    public void innerAccess() {
        System.out.println("내부 호출:");
        publicField = 100;
        defaultField = 200;
        privateField = 300; // 내 안방이니까 private도 접근 가능
        System.out.println("모든 필드 접근 완료");
    }
}
