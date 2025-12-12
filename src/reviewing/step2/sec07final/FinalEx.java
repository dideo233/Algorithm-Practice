package reviewing.step2.sec07final;

public class FinalEx {

    /**
     * final이란? > 상수로서 초기화 이후 값 변경 불가능 (class, method, 변수 등에 사용 가능)
     * - 기본형 사용 시 값 변경 X, 참조형 사용 시 참조 변경 X
     * - 객체 생성 후 할당하면 참조는 변경 불가하지만, 참조 대상 객체의 내부 값은 변경 가능
     *
     * 상수란? > 변하지 않고 일정한 값을 갖는 수. 자바에서는 단 하나만 존재하는 고정된 값을 의미함.
     * - static final 키워드 사용, 대문자로 작성하며, 단어는 언더바로 구분
     * - 필드에 직접 접근하여 사용
     * - 기능이 아닌 고정된 값 자체가 목적이므로, 값 변경이 불가능하기 때문에 필드 직접 접근해도 데이터가 변하는 문제 없음
     */

    public static void main(String[] args) {
        //final 지역 변수
        final int data;
        data = 10; //최초 한번만 할당 가능
        // data = 20; //컴파일 오류

        //final 필드 - 생성자 초기화 (final임에도 각 인스턴스마다 다른 값을 초기화 가능)
        System.out.println("생성자 초기화");
        Constructinit constructinit1 = new Constructinit(10);
        Constructinit constructinit2 = new Constructinit(20);
        System.out.println(constructinit1.value);
        System.out.println(constructinit2.value);
        
        //final 필드 - 필드 초기화
        System.out.println("필드 초기화");
        FieldInit fieldInit1 = new FieldInit();
        FieldInit fieldInit2 = new FieldInit();
        System.out.println(fieldInit1.value);
        System.out.println(fieldInit2.value);
        //필드 초기화 시 모든 인스턴스는 동일 값을 가진다. 따라서 메모리 낭비 (중복)
        // > 따라서 static 영역 활용 (공유)

        //상수
        System.out.println("상수");
        System.out.println(FieldInit.CONST_VALUE);
        //필드 초기화를 시도한다면 static final로 쓰는 게 효과적

        //상수 활용
        System.out.println("프로그램 최대 참여자 수 : " + Constant.MAX_USERS);
        int currentUserCount = 999;
        process(currentUserCount++);
        process(currentUserCount++);
    }

    private static void process (int currentUserCount) {
        System.out.println("참여자 수: " + currentUserCount);
        if(currentUserCount > Constant.MAX_USERS) {
            System.out.println("대기자로 등록");
        } else {
            System.out.println("게임에 참여");
        }
    }
}
