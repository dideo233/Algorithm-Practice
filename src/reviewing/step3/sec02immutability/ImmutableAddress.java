package reviewing.step3.sec02immutability;

/**
 * [불변 객체] - 생성 후 값을 바꿀 수 없음 (final, setter 없음)
 */
public class ImmutableAddress {

    private final String value;

    public ImmutableAddress(String value) {
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
