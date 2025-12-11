package reviewing.step2.sec02type;

/**
 * Java의 값 타입(Primitive Type)과 참조 타입(Reference Type)의 동작 방식 비교
 * - 기본형 변수: 값을 직접 저장 (Pass by Value)
 * - 참조형 변수: 객체의 주소(참조)를 저장 (Pass by Reference 처럼 동작)
 * - null의 의미와 NullPointerException
 */
public class TypeEx {

    public static void main(String[] args) {

        /**
         * 1. 기본형(Primitive Type)의 값 복사: Pass by Value
         * 변수에 실제 '값'이 저장되므로, 다른 변수에 할당하면 값이 '복사'됨.
         * 복사된 이후에는 서로에게 아무런 영향을 주지 않는 독립적인 변수가 됨.
         */
        System.out.println("--- 1. 기본형 값 복사 (Pass by Value) ---");
        int a = 10;
        int b = a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        a = 20;
        System.out.println("변경 a = 20");
        System.out.println("a = " + a + ", b = " + b);

        b = 30;
        System.out.println("변경 b = 30");
        System.out.println("a = " + a + ", b = " + b);

        /**
         * 2. 참조형(Reference Type)의 값 복사: 주소(참조) 복사
         * 변수에 객체의 '주소(참조)값'이 저장되므로, 다른 변수에 할당하면 '주소값'이 복사됨.
         * 결과적으로 두 변수는 '같은 주소'를 가리키므로, '하나의 객체'를 공유하게 됨.
         */
        System.out.println("\n--- 2. 참조형 주소 복사 (Pass by Reference 처럼 동작) ---");
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA;

        System.out.println("dataA 참조값 = " + dataA);
        System.out.println("dataB 참조값 = " + dataB);
        System.out.println("dataA.value: " + dataA.value + ", dataB.value: " + dataB.value);

        dataA.value = 20;
        System.out.println("dataA.value: " + dataA.value + ", dataB.value: " + dataB.value);

        dataB.value = 30;
        System.out.println("dataA.value: " + dataA.value + ", dataB.value: " + dataB.value);


        /**
         * 3. 메서드 호출 시의 값 전달 방식
         * Java는 항상 '값 복사(Pass by Value)' 방식으로 인자를 전달함.
         * - 기본형: 변수의 '실제 값'이 복사되어 전달됨 -> 원본 불변
         * - 참조형: 변수의 '주소 값'이 복사되어 전달됨 -> 원본 객체의 내용 변경 가능
         */
        System.out.println("\n--- 3. 메서드 호출 시 값 전달 ---");
        int primitiveNum = 10;
        System.out.println("기본형 메서드 호출 전: " + primitiveNum);
        changePrimitive(primitiveNum);
        System.out.println("기본형 메서드 호출 후: " + primitiveNum);

        Data referenceData = new Data();
        referenceData.value = 10;
        System.out.println("참조형 메서드 호출 전: " + referenceData.value);
        changeReference(referenceData);
        System.out.println("참조형 메서드 호출 후: " + referenceData.value);


        /**
         * 4. null 과 NullPointerException
         * - null: '참조 없음'. 참조형 변수가 어떠한 객체도 가리키고 있지 않다는 의미.
         * - NullPointerException (NPE): null 값을 가진 참조 변수에 접근(e.g., '.')하려 할 때 발생하는 런타임 에러.
         */
        System.out.println("\n--- 4. null과 NullPointerException ---");
        Data data = null;
        System.out.println("1. 초기 상태: data = " + data);
        data = new Data();
        System.out.println("2. 객체 할당 후 주소: data = " + data);
        data = null;
        System.out.println("3. 참조 제거 후: data = " + data);

        // if (data != null) { data.value ... } 와 같은 null 체크가 반드시 필요함.
        // System.out.println(data.value); // 주석 해제 시 NullPointerException 발생
    }

    // 기본형 매개변수: 호출된 곳의 primitiveNum 값(10)이 복사되어 x에 전달됨
    public static void changePrimitive(int x) {
        x = 20;
    }

    // 참조형 매개변수: 호출된 곳의 referenceData의 '주소값'이 복사되어 data에 전달됨
    public static void changeReference(Data data) {
        data.value = 20;
    }
}
