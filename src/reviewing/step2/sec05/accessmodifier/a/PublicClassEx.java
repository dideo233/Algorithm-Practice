package reviewing.step2.sec05.accessmodifier.a;

// 파일명(PublicClassInnerEx)과 동일한 public 클래스
public class PublicClassEx {
    public static void main(String[] args) {
        // 같은 패키지(파일) 내의 default 클래스 생성 가능
        DefaultClass1 c1 = new DefaultClass1();
        DefaultClass2 c2 = new DefaultClass2();
    }
}

// default 접근 제어자: 이 패키지(reviewing...accessmodifier.a) 안에서만 보임
class DefaultClass1 {
}

class DefaultClass2 {
}
