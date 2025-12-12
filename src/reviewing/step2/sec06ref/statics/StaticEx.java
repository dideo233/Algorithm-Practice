package reviewing.step2.sec06ref.statics;

import reviewing.step2.sec06ref.memory.Data;

public class StaticEx {
    public static void main(String[] args) {
        // 1. 인스턴스 변수 (독립적)
        Data data1 = new Data("A");
        System.out.println("A count = " + data1.getCount());
        Data data2 = new Data("B");
        System.out.println("B count = " + data1.getCount());
        // 각자 1로 초기화됨, 공유 안 됨.
        
        // 2. 인스턴스로 공통 관리
        // 문제점: 카운트 공유를 위해 외부 객체(Counter)를 만들어서 넘겨줘야 함. 결합도 증가.
        Counter counter = new Counter();
        Data data4 = new Data("D", counter);
        System.out.println("D count = " + counter.getCount());
        Data data5 = new Data("E", counter);
        System.out.println("E count = " + counter.getCount());

        // 3. 스태틱 변수
        StaticData staticData1 = new StaticData("A");
        System.out.println("A count : " + StaticData.getCount());

        StaticData staticData2 = new StaticData("B");
        System.out.println("B count : " + StaticData.getCount());

        StaticData staticData3 = new StaticData("C");
        System.out.println("C count : " + StaticData.getCount());
        // 클래스 변수는 단 하나만 존재(메서드 영역)하므로 공유됨.

        StaticData staticData4 = new StaticData("D");
        System.out.println(staticData4.getCount());
        System.out.println(StaticData.getCount());
        // 인스턴스(staticData4)로 접근 가능하지만, 클래스(StaticData)로 접근하는 게 정석 (객체에 속한 걸로 오해 방지).

        // 4. 스태틱 메서드
        String s = "hello java";

        // DecoUtil decoUtil = new DecoUtil();
        // String deco = decoUtil.deco(s);
        // 멤버 변수도 없고, 단순하게 기능을 제공할 뿐. > 객체 생성 불필요!
        // 인스턴스는 멤버 변수(데이터 관리)를 사용하는 목적이 큰데, 이게 없음. > 스태틱 사용

        String deco = DecoUtil.deco(s);
        System.out.println("before : " + deco);
        System.out.println("after : " + deco);

        System.out.println("1. 정적 호출");
        DecoUtil.staticCall();

        System.out.println("2. 인스턴스 호출");
        DecoUtil decoUtil = new DecoUtil();
        decoUtil.instanceCall();;




    }
}
