package reviewing.step3.sec02immutability.example.date;

public class ImmutableMyDate {
    private final int year;
    private final int month;
    private final int day;

    public ImmutableMyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public ImmutableMyDate withYear(int newYear) {
        return new ImmutableMyDate(newYear, this.month, this.day);
    }

    public ImmutableMyDate withMonth(int newMonth) {
        return new ImmutableMyDate(this.year, newMonth, this.day);
    }

    public ImmutableMyDate withDay(int newDay) {
        return new ImmutableMyDate(this.year, this.month, newDay);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
