package reviewing.step2.sec06ref.memory;

public class StackAndHeapEx {
    public static void main(String[] args) {
        System.out.println("main start");
        method1();
        System.out.println("main end"); // main 종료 시 스택 프레임 완전 소멸
    }

    static void method1() {
        System.out.println("method1 start");
        Data data = new Data(10); // Heap에 객체 생성, Stack에 참조값(data) 저장
        method2(data);            // 참조값 전달
        System.out.println("method1 end");
        // 메서드 종료 시 data 변수(참조) 제거 -> Heap의 Data 객체는 GC 대상이 됨
    }

    static void method2(Data data) {
        System.out.println("method2 start");
        System.out.println("data.value = " + data.getCount());
        System.out.println("method2 end");
    }
}
