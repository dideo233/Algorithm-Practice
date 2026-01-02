package reviewing.step3.sec01object.equals;


public class UserV2 {
    private String id;

    public UserV2(String id) {
        this.id = id;
    }

    /**
     * UserV2의 동등성은 Id로 비교 (Id가 같으면 논리적으로 동일한 객체)
     */
    @Override
    public boolean equals(Object obj) {
        UserV2 user = (UserV2) obj;
        return id.equals(user.id);
    }

}
