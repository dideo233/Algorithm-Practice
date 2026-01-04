package reviewing.step3.sec02immutability;

public class ImputableAddress {

    private final String value;

    public ImputableAddress(String value) {
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
