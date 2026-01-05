package reviewing.step3.sec02immutability;

/**
 * [가변 객체] - 값을 언제든 바꿀 수 있음
 */
public class Address {
    private String value;

    public Address(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Address{" +
                "value='" + value + '\'' +
                '}';
    }

}
