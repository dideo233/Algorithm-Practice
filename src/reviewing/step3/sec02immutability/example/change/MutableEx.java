package reviewing.step3.sec02immutability.example.change;

public class MutableEx {
    public static void main(String[] args){
        // 가변 객체 - 원본이 변경됨
        MutableObj obj = new MutableObj(10);
        obj.add(20);
        System.out.println("obj = " + obj.getValue());  // 30 (원본 변경)

        // 불변 객체 - 새 객체 반환
        ImmutableObj obj1 = new ImmutableObj(10);
        ImmutableObj obj2 = obj1.add(20);
        System.out.println("obj1 = " + obj1.getValue());  // 10 (원본 유지)
        System.out.println("obj2 = " + obj2.getValue());  // 30 (새 객체)
    }
}
