package reviewing.step3.sec02immutability;


/**
 * [공유 참조와 사이드이펙트]
 * 사이드이펙트 : 어떤 계산이 주된 작업 외에 의도하지 않은 부수 효과를 일으키는 것.
 * -> 기본형은 값을 복사하여 대입하니 발생하지 않는 반면, 참조형은 참조값을 복사하여 대입하니 같은 객체가 공유될 수 있다. (공유 참조!)
 */
public class DataTypeEx {
    public static void main(String[] args) {
        // 기본형 : 하나의 값을 여러 변수에서 공유하지 않음 (다른 메모리 공간)
        int primitive1 = 10;
        int primitive2 = primitive1; // 값을 복사하여 대입
        System.out.println("primitive1 = " + primitive1);
        System.out.println("primitive2 = " + primitive2);

        primitive2 = 20;
        System.out.println("20 -> primitive2 ");
        System.out.println("primitive1 = " + primitive1);
        System.out.println("primitive2 = " + primitive2);


        // 참조형 : 하나의 객체를 참조값을 통해 여러 변수에서 공유 (
        Address ref1 = new Address("서울");
        Address ref2 = ref1; //참조값을 복사하여 대입 (해당 참조값이 가리키는 메모리 공간은 ref1, ref2 동일)
        System.out.println("\nref1 = " + ref1);
        System.out.println("ref2 = " + ref2);

        ref2.setValue("부산");
        System.out.println("부산 -> ref2");
        System.out.println("ref1 = " + ref1); //사이드 이펙트, B의 주소값을 변경할 의도였으나 A도 의도치 않게 변경
        System.out.println("ref2 = " + ref2);

        // 사이드 이펙트 해결
        // 문제는 같은 객체의 참조를 공유하니 발생했다. 따라서 공유하지 않도록 서로 다른 객체를 참조하게 하면 해결된다.
        Address ref3 = new Address("서울");
        Address ref4 = new Address("서울");
        System.out.println("\nref3 = " + ref3);
        System.out.println("ref4 = " + ref4);

        ref4.setValue("부산");
        System.out.println("부산 -> ref4");
        System.out.println("ref3 = " + ref3); 
        System.out.println("ref4 = " + ref4);

        // 근본 문제
        // -> 여러 변수가 하나의 객체를 공유하는 것을 막을 방법은 없다.
        // 그럼 ref2 = ref1 같은 코드 작성하지 않는다면 사이드 이펙트 문제가 발생하지 않을까?
        // -> 문법 오류는 아나다! 새 객체를 만들든, 기존 객체를 대입해도 문법상 정상이다
        // -> 실수가 발생할 수 있다

        Address ref5 = new Address("서울");
        Address ref6 = ref5;
        System.out.println("\nref5 = " + ref5);
        System.out.println("ref6 = " + ref6);

        // 이런 식으로 코드가 점차 복잡해지면 비례적으로 공유 참조를 찾기 어려워진다.
        // 따라서 단순히 개발자가 조심하는 것만으로는 공유 참조로 인한 사이드이펙트 막기 까다롭다 (문제 발생!)
        change(ref6, "부산");
        System.out.println("ref5 = " + ref1);
        System.out.println("ref6 = " + ref2);

        // 문제 고찰
        // 핵심은 객체를 공유하였기 때문인데, 사실 객체 공유 자체는 문제가 아니다. (메모리 절약과 생성 시간 단축하여 성능상 효율 있기에 장점 있음!)
        // 근본적으로는 문제 발생은 공유 참조가 아닌 '공유된 객체의 값을 변경'함에 있음

        // 근본 문제의 해결 -> 불변 객체(Immutable Object) 도입. 상태(객체 내부의 값, 필드, 멤버 변수)가 변하지 않는 객체를 말함
        // 클래스 작성 시 내부 필드를 final로 선언하면 됨 (생성자를 통해서만 값 설정 가능)
        // -> final이 아니라 쳐도 어떻게든 필드 값을 변경할 수 없게 설계하면 불변 클래스가 됨 (예: private 필드에 setter만 있는 경우 등)

        ImputableAddress imputableRef1 = new ImputableAddress("서울");
        ImputableAddress imputableRef2 = imputableRef1; //참조값 대입 자체는 정당함
        System.out.println("\nimputableRef1 = " + imputableRef1);
        System.out.println("imputableRef2 = " + imputableRef2);

        // imputableRef2.setValue("부산"); // 값을 부산으로 변경해야 함. 불변 객체라 변경 불가!
        imputableRef2 = new ImputableAddress("부산"); //새 불변 객체 생성
        System.out.println("imputableRef1 = " + imputableRef1);
        System.out.println("imputableRef2 = " + imputableRef2);

        // 결론
        // 공유 참조는 막을 수 없다. 따라서 사이드 이펙트는 발생한다. 
        // 이를 방지하기 위해 불변 객체라는 제약을 도입하여, 개발자의 실수를 방지하여 사이드 이펙트를 원천 차단한다.

    }

    public static void change(Address address, String changeAddress) {
        System.out.println("change address: " + changeAddress);
        address.setValue(changeAddress);
    }
}

