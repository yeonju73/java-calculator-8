package calculator.domain;

public class PositiveNumber {
    private final int value;

    private PositiveNumber(int number) {
        this.value = number;
    }

    public static PositiveNumber of(int value) {
        checkPositiveNumber(value);
        return new PositiveNumber(value);
    }

    private static void checkPositiveNumber(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
