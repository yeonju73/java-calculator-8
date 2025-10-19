package calculator.domain;

import calculator.exception.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
