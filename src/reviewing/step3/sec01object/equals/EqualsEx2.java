package reviewing.step3.sec01object.equals;

public class EqualsEx2 {
    public static void main(String[] args) {
        UserV2 user1 = new UserV2("id-100");
        UserV2 user2 = new UserV2("id-100");

        // 참조는 다르지만 동일한 ID를 가지므로 논리적으로 동등하다
        System.out.println("Identity = " + (user1 == user2));      // false
        System.out.println("Equality = " + (user1.equals(user2))); // true
    }
}
