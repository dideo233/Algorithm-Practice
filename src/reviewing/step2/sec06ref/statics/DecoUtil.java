package reviewing.step2.sec06ref.statics;

public class DecoUtil {
    private int instanceValue;
    private static int staticValue;

    public static String deco(String str){
        return "*" + str + "*";
    }

    public static void staticCall(){
        staticValue++;
        staticMethod();
        // 인스턴스 변수 및 메서드 접근 불가 (컴파일 오류)
        // instanceValue++;
        // instanceMethod();
        // 이유: 정적 메서드는 참조값 없이 쓰는데, 인스턴스 기능은 참조값 기반이라 못 쓰는 게 당연.
    }

    public static void staticCall(DecoUtil decoUtil) {
        decoUtil.instanceValue++;
        decoUtil.instanceMethod();
        // 단, 매개변수로 객체를 전달받으면 인스턴스 변수 사용 가능.
    }

    public void instanceCall(){
        instanceValue++;
        instanceMethod();

        staticValue++;
        staticMethod();
        // 힙 영역에 객체 생성됨 > 클래스 변수(Static)는 이미 있으니 언제든 사용 가능.
    }

    private static void staticMethod(){
        System.out.println("staticValue : " + staticValue);

    }
    private void instanceMethod(){
        System.out.println("instanceValue : " + instanceValue);
    }
}
