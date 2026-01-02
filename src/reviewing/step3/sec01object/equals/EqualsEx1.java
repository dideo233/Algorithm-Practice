package reviewing.step3.sec01object.equals;

/**
 * [동일성(Identity)과 동등성(Equality)]
 * - 동일성 (`==`): 두 객체가 물리적으로 '같은 메모리 주소'를 가리키는가? (완전히 같은 객체인가)
 * - 동등성 (`equals`): 두 객체가 논리적으로 동등한 객체인가?
 *
 * [equals() 메서드의 특징]
 * - 기본 동작: `Object` 클래스의 기본 `equals()`는 내부적으로 `==` 연산자를 사용하여 동일성(주소값)을 비교함. (재정의를 전제로 함)
 * - 재정의(Override): 물리적으로 다른 객체라도, 특정 기준(ID, 주민번호 등)에 따라 기준값이 같다면 '논리적으로 같다(True)'고 판단함.
 *   (e.g., `String` 클래스는 메모리 주소가 달라도 문자열 내용(Content)이 같으면 동등하다고 판단하도록 `equals`가 이미 재정의되어 있음)
 *
 * [equals() 구현 규약 5가지]
 * - 반사성: 나 자신과는 항상 같아야 함. (x.equals(x) -> true)
 * - 대칭성: A가 B와 같으면, B도 A와 같아야 함.
 * - 추이성: A=B이고 B=C이면, A=C여야 함.
 * - 일관성: 상태가 변하지 않는 한 결과는 계속 같아야 함.
 * - null 아님: null과 비교 시 항상 false여야 함.
 */
public class EqualsEx1 {
    public static void main(String[] args) {
        UserV1 user1 = new UserV1("id-100");
        UserV1 user2 = new UserV1("id-100");

        // 1. 동일성 비교 (Identity)
        // 서로 다른 메모리 공간에 생성된 객체이므로 주소값이 다름 -> false
        System.out.println("Identity (==) = " + (user1 == user2));

        // 2. 동등성 비교 (Equality)
        // UserV1 클래스는 equals()를 재정의하지 않았음.
        // 따라서 Object의 기본 equals()(=동일성 비교)가 호출됨 -> false
        System.out.println("Equality (equals) = " + (user1.equals(user2)));

        // [결론]
        // - 논리적인 값(ID)이 같을 때 true를 반환하고 싶다면, User 클래스에서 equals()를 오버라이딩 해야 함.
        // - (참고) equals()를 재정의할 때는 hashCode()도 함께 재정의하는 것이 원칙.
    }
}
