package reviewing.step2.sec09polymorphism.overriding;

public class OverridingEx {

    public static void main(String[] args) {
        //자식 변수가 자식 인스턴스 참조
        Child child = new Child();
        System.out.println("child > child");
        System.out.println("value = " + child.value);
        child.method();

        System.out.println();

        //부모 변수가 부모 인스턴스 참조
        Parent parent = new Parent();
        System.out.println("parent > parent");
        System.out.println("value = " + parent.value);
        parent.method();

        System.out.println();

        //부모 변수가 자식 인스턴스 참조 (다형적 참조)
        Parent poly = new Child();
        System.out.println("Parent > Child");
        System.out.println("value = " + poly.value); //변수는 참조 타입(Parent)을 따라감
        poly.method(); //메서드는 실제 인스턴스(Child)의 오버라이딩된 버전을 실행

        /**
         * [다형성과 오버라이딩의 우선순위]
         * 1. poly.value
         *  - 필드는 다형성이 적용되지 않음.
         *  - poly가 Parent 타입이므로, 메모리에 Child가 있든 말든 Parent의 value를 읽음. (참조 변수의 '타입' 값 가져옴)
         *
         * 2. poly.method()
         *  - 메서드는 오버라이딩이 적용됨. (오버라이딩 된 메서드는 부모 메서드 가림)
         *  - 호출 시 Parent 타입부터 탐색하지만, 하위(Child)에 오버라이딩 된 메서드가 있으면 그게 '우선권'을 가짐.
         *  - 따라서 Parent.method()가 아니라 Child.method()가 실행됨.
         */
    }
}
