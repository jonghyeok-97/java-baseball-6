package baseball.domain;

public class Number {
    private final int number;

    private Number(int number) {
        validate(number);
        this.number = number;
    }

    public static Number from(int number) {
        return new Number(number);
    }

    public boolean isSame(Number other) {
        return this.number == other.number;
    }

    public int getValue() {
        return this.number;
    }

    private void validate(int number) {
        if (number == 0) {
            throw new IllegalArgumentException();
        }
    }
}
